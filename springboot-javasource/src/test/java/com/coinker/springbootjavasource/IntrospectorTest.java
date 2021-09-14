package com.coinker.springbootjavasource;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.beans.*;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author Cui Shenpeng
 * @Classname IntrospectorTest
 * @Description 内省机制测试
 * @Date 2021/9/14 17:09
 */
public class IntrospectorTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User {
        private String username;
        private Integer age;
        private Date createTime;

    }

    @Test
    public void test1() throws IntrospectionException {
        //获取 User Bean 信息
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class);
        //属性描述
        PropertyDescriptor[] propertyDescriptors = userBeanInfo.getPropertyDescriptors();
        System.out.println("属性描述：");
        Stream.of(propertyDescriptors).forEach(System.out::println);
        //方法描述
        System.out.println("方法描述：");
        MethodDescriptor[] methodDescriptors = userBeanInfo.getMethodDescriptors();
        Stream.of(methodDescriptors).forEach(System.out::println);
        //事件描述
        System.out.println("事件描述：");
        EventSetDescriptor[] eventSetDescriptors = userBeanInfo.getEventSetDescriptors();
        Stream.of(eventSetDescriptors).forEach(System.out::println);
    }

    @Test
    public void test2() throws IntrospectionException {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        String path = "user.";
        Properties properties = yaml.getObject();
        System.out.println(properties);
        User user = new User();
        //获取 User Bean 信息，排除 Object
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
        //属性描述
        PropertyDescriptor[] propertyDescriptors = userBeanInfo.getPropertyDescriptors();
        // 通过 PropertyDescriptor 可以基于字段名为可写属性设置值。
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            //获取属性名称
            String property = propertyDescriptor.getName();
            try {
                propertyDescriptor.getWriteMethod().invoke(user, properties.get(path + property));
            } catch (IllegalAccessException | InvocationTargetException ignored) {
            }
        });
        System.out.println(user);
    }

    @Test
    public void test5() {
        User user = new User();
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("username", "zhangsan");
        pvs.add("age", 1);
        bw.setPropertyValues(pvs);
        System.out.println(user);
    }

    /**
     * 日期属性编辑器
     */
    class DatPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) {
            try {
                setValue((text == null) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(text));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test6() throws IntrospectionException, FileNotFoundException {
        Map<String,Object> properties = ImmutableMap.of("age",1,"username","zhangsan","createTime","2020-01-01");
        User user = new User();
        //获取 User Bean 信息，排除 Object
        BeanInfo userBeanInfo = Introspector.getBeanInfo(User.class, Object.class);
        //属性描述
        PropertyDescriptor[] propertyDescriptors = userBeanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            //获取属性名称
            String property = propertyDescriptor.getName();
            //值
            Object value = properties.get(property);
            if (Objects.equals("createTime", property)) {
                //设置属性编辑器
                propertyDescriptor.setPropertyEditorClass(DatPropertyEditor.class);
                //创建属性编辑器
                PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                //添加监听器
                propertyEditor.addPropertyChangeListener(evt -> {
                    //获取转换后的value
                    Object value1 = propertyEditor.getValue();
                    setPropertyValue(user, propertyDescriptor, value1);
                });
                propertyEditor.setAsText(String.valueOf(value));
                return;
            }
            setPropertyValue(user, propertyDescriptor, value);
        });
        System.out.println(user);
    }

    /**
     * 设置属性值
     */
    private void setPropertyValue(User user, PropertyDescriptor propertyDescriptor, Object value1) {
        try {
            propertyDescriptor.getWriteMethod().invoke(user, value1);
        } catch (IllegalAccessException | InvocationTargetException ignored) {
        }
    }

     class User2 {

        private String username;

        private Integer age;

        /**
         * 属性（生效）变化监听器管理器
         */
        private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

        /**
         * 启动属性（生效）变化
         * @param propertyName
         * @param oldValue
         * @param newValue
         */
        private void firePropertyChange(String propertyName, String oldValue, String newValue) {
            PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
            propertyChangeSupport.firePropertyChange(event);
        }

        /**
         * 添加属性（生效）变化监听器
         */
        public void addPropertyChangeListener(PropertyChangeListener listener){
            propertyChangeSupport.addPropertyChangeListener(listener);
        }

        /**
         * 删除属性（生效）变化监听器
         */
        public void removePropertyChangeListener(PropertyChangeListener listener){
            propertyChangeSupport.removePropertyChangeListener(listener);
        }

        /**
         * 获取属性（生效）变化监听器
         */
        public PropertyChangeListener[] getPropertyChangeListeners() {
            return propertyChangeSupport.getPropertyChangeListeners();
        }

    /*    public void setUsername(String username) {
            String oldValue = this.username;
            this.username = username;
            firePropertyChange("username", oldValue, username);
        }*/

         public void setAge(Integer age) {
             this.age = age;
         }


         /**
          * 属性（否决）变化监听器
          */
         private VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

         /**
          * 启动属性（否决）变化
          * @param propertyName
          * @param oldValue
          * @param newValue
          */
         private void fireVetoableChange(String propertyName, String oldValue, String newValue) throws PropertyVetoException {
             PropertyChangeEvent event = new PropertyChangeEvent(this, propertyName, oldValue, newValue);
             vetoableChangeSupport.fireVetoableChange(event);
         }

         /**
          * 添加属性（否决）变化监听器
          */
         public void addVetoableChangeListener(VetoableChangeListener listener){
             vetoableChangeSupport.addVetoableChangeListener(listener);
         }

         /**
          * 删除属性（否决）变化监听器
          */
         public void removeVetoableChangeListener(VetoableChangeListener listener){
             vetoableChangeSupport.removeVetoableChangeListener(listener);
         }

         public void setUsername(String username) throws PropertyVetoException {
             String oldValue = this.username;
             fireVetoableChange("username",oldValue,username);
             this.username = username;
             firePropertyChange("username", oldValue, username);
         }
         // getter/setter
        // toString
    }

    @Test
    public void test3() throws PropertyVetoException {
        User2 user = new User2();
        user.setAge(1);
        user.setUsername("zhangsan");
        user.addPropertyChangeListener(System.out::println);
        user.setUsername("lisi");
        user.setUsername("wangwu");
    }

    @Test
    public void test4() throws PropertyVetoException {
        User2 user = new User2();
        user.setAge(1);
        user.addVetoableChangeListener(evt -> {
            System.out.println(evt.getNewValue()+",,"+evt.getOldValue());
            if (Objects.isNull(evt.getNewValue())) {
                throw new PropertyVetoException("username 不能为null", evt);
            }
        });
        user.addPropertyChangeListener(System.out::println);
        user.setUsername("lisi");
        user.setUsername(null);
    }
}
