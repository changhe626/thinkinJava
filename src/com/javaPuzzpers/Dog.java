package com.javaPuzzpers;

/**
 * Created by zk on 2017/10/30.
 * 作用: 静态方法的重写,然后子类使用对象进行调用的问题
 */
public class Dog {

    public static  void say(){
        System.out.println("wanwgangwang");
    }
}



class BlackDog extends  Dog{

    //因为是static 方法,所以没有办法加上@Override
    public static  void say(){
        System.out.println("黑狗,不停的叫着");
    }
}

class Test{
    public static void main(String[] args) {
        Dog dog = new BlackDog();
        dog.say();   //
    }
}