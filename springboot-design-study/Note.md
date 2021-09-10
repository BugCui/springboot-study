# 设计模式

---

## 1.观察者模式

### 示例：

定义一个天气观察器，然后把两个观察者注册上去。让天气随着时间变化， 变化的同时，遍历所有注册的观察者，并对其进行通知。

### 应用

在下面任何一种情况下都可以使用观察者模式

* 当抽象具有两个方面时，一个方面依赖于另一个方面。将这些方面封装在单独的对象中，可以使你分别进行更改和重用
* 当一个对象的改变的同时需要改变其他对象，同时你又不知道有多少对象需要改变时
* 当一个对象可以通知其他对象而无需假设这些对象是谁时。换句话说，你不想让这些对象紧耦合。

### Java中的例子

* [java.util.Observer](http://docs.oracle.com/javase/8/docs/api/java/util/Observer.html)
* [java.util.EventListener](http://docs.oracle.com/javase/8/docs/api/java/util/EventListener.html)
* [javax.servlet.http.HttpSessionBindingListener](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSessionBindingListener.html)
* [RxJava](https://github.com/ReactiveX/RxJava)

## 2.模板设计模式

在面向对象的编程中，模板方法是Gamma等人确定的行为设计模式之一。在《设计模式》一书中。模板方法是父类中一个方法，通常是一个抽象父类， 根据许多高级步骤定义了操作的骨架。这些步骤本身由与模板方法在同一类中的其他帮助程序方法实现。

> 参考chengying项目中的抽象父类实现注册TCP通道的基本逻辑，子类把具体通道传入进去，父类取到并执行。

## 3.Reactor设计模式
* Netty线程模型