package com.designpattern.visit;

/**
 * Created by zk on 2017/10/31.
 * 作用: com.designpattern.visit.
 */
/**
 * 在例子中，对于类A来说，类B就是一个访问者。但是这个例子并不是访问者模式的全部，虽然直观，但是它的可扩展性比较差，
 * 下面我们就来说一下访问者模式的通用实现，通过类图可以看到，在访问者模式中，主要包括下面几个角色：
 抽象访问者：抽象类或者接口，声明访问者可以访问哪些元素，具体到程序中就是visit方法中的参数定义哪些对象是可以被访问的。
 访问者：实现抽象访问者所声明的方法，它影响到访问者访问到一个类后该干什么，要做什么事情。
 抽象元素类：接口或者抽象类，声明接受哪一类访问者访问，程序上是通过accept方法中的参数来定义的。抽象元素一般有两类方法，
 一部分是本身的业务逻辑，另外就是允许接收哪类访问者来访问。
 元素类：实现抽象元素类所声明的accept方法，通常都是visitor.visit(this)，基本上已经形成一种定式了。
 结构对象：一个元素的容器，一般包含一个容纳多个不同类、不同接口的容器，如List、Set、Map等，在
 项目中一般很少抽象出这个角色。
 */
public class A {

    public static void main(String[] args) {
        A a = new A();
        a.method1();
        a.method2(new B());
    }


    public void method1(){
        System.out.println("我是A");
    }

    public void method2(B b){
        b.showA(this);
    }
}

class B {
    public void showA(A a){
        a.method1();
    }
}
