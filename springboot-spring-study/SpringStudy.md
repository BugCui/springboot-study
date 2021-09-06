## SpringStudy

### 1.ApplicationListener

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

### 2.