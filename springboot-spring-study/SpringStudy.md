## SpringStudy

### 1.监听器ApplicationListener

自己定义一个MySpringContextListener实现ApplicationListener，并且在程序启动时实例化
MySpringContextListener的Bean，发现程序每次启动时，MySpringContextListener都能收到5次执行。

思考：实现ApplicationListener的意义？

摘自官网的定义：
> 事件处理ApplicationContext是通过ApplicationEvent 类和ApplicationListener接口提供的。如果将实现ApplicationListener接口的 bean 部署到上下文中，则每次 ApplicationEvent将 发布到 时ApplicationContext，都会通知该 bean。本质上，这是标准的观察者设计模式。

* Spring提供的内置事件：ContextRefreshedEvent、ContextStartedEvent、ContextStoppedEvent、ContextClosedEvent、
  RequestHandledEvent、ServletRequestHandledEvent

* demo1: 模拟手动触发一个邮件发送事件，接收方监听到邮件event，打印邮件信息。
* demo2: 内置监听器测试
* demo3: 基于注解的监听器

> 参考：https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#spring-core

### 2.自动装配

META-INF 文件夹的作用

* META-INF 存在程序入口相关信息, 每个jar 都会有这个文件夹,里面的 MANIFEST文件 记录这些信息
* WEB-INF 使用web 项目才会有这个文件夹,普通的 j2se项目 是没有这个文件夹的 SpringBoot自动装配，启动时加载META-INF下的文件。参考类：SpringFactoriesLoader

### 3.Bean实例对象

如果你提供了一个Jar包供第三方用户使用，那么你这个jar包中的Bean，就不能被第三方加载，那么如何才能被加载呢？

这个时候在将配置放在指定的文件中即可，使用者会自动加载，从而避免的代码的侵入

* 在资源目录下新建目录 META-INF
* 在 META-INF 目录下新建文件 spring.factories
* 在文件中添加

举例：在SpringBoot-MongoDB jar包下就有spring.factories等配置

> 参考：https://www.cnblogs.com/qdhxhz/p/11006289.html
> 
> SpringBoot配置项说明：https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/appendix-application-properties.html#common-application-properties

### 4.注解

@Conditional注解： @Conditional是Spring4新提供的注解，它的作用是按照一定的条件进行判断，满足条件的才给容器注册Bean。
  
@ConditionalOnBean         //	当给定的在bean存在时,则实例化当前Bean

@ConditionalOnMissingBean  //	当给定的在bean不存在时,则实例化当前Bean

@ConditionalOnClass        //	当给定的类名在类路径上存在，则实例化当前Bean

@ConditionalOnMissingClass //	当给定的类名在类路径上不存在，则实例化当前Bean

> 参考：https://www.cnblogs.com/qdhxhz/p/11020434.html
> 
> 参考：https://www.cnblogs.com/qdhxhz/p/11027546.html