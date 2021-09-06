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
