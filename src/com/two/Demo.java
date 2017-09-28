package com.two;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {

    static int i=43;

    public static  void main(String[] args){
        Demo demo2 = new Demo();
        Class<? extends Demo> aClass = demo2.getClass();

        System.out.println(aClass);
        System.out.println(Demo.class);
        System.out.println(aClass.isInstance(demo2));


        /*Demo demo = null;
        try {
            System.out.println(1);
           //int j=1/0;
            System.out.println(1.1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(2);
        } finally {
            System.out.println(3);
        }
        Demo demo1 = new Demo();
        demo.i++;
        System.out.println(demo.i);
        System.out.println(demo1.i);
        System.out.println(54/5);

        say(new ArrayList());
*/


    }


   static  void say(Collection c){

    }

    static  void say2(ArrayList c){

    }
}
