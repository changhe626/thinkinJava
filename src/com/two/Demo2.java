package com.two;

public class Demo2 {


    public  static void main(String[] args){
       say("1",4,'a');

    }

    static void say(Object...args){
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

}
