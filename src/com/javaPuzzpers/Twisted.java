package com.javaPuzzpers;

/**
 * Created by zk on 2017/10/30.
 * 作用: com.javaPuzzpers.
 */
public class Twisted {


    private final String name;

    public Twisted(String name) {
        this.name = name;
    }

    private String name(){
        return name;
    }
    private void reproduce(){
        new Twisted("reproduced"){
            void printName(){
                //匿名类不继承name() 方法,所以指向的是main的 this
                System.out.println(name());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Twisted("hello world").reproduce();
        //打印的是hello world
    }
}
