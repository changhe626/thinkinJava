package com.myStrictfp;

/**
 * Created by zk on 2017/10/19.
 * 作用: com.myStrictfp.
 *
 * stricftp 可以使用在java 类上,方法上,还有接口上
 *
 * 一旦使用了关键字strictfp来声明某个类、接口或者方法时，
 * 那么在这个关键字所声明的范围内所有浮点运算都是精确的，符合IEEE-754规范的。例如一个类被声明为strictfp，
 * 那么该类中所有的方法都是strictfp的。
 *
 */
public class Test {

    @org.junit.Test
    public void test(){
        float aFloat = 0.6710339f;
        double aDouble = 0.04150553411984792d;
        double sum = aFloat + aDouble;
        float quotient = (float)(aFloat / aDouble);
        System.out.println("float: " + aFloat);
        System.out.println("double: " + aDouble);
        System.out.println("sum: " + sum);
        System.out.println("quotient: " + quotient);
    }


    @org.junit.Test
    public strictfp void test2(){
        float aFloat = 0.6710339f;
        double aDouble = 0.04150553411984792d;
        double sum = aFloat + aDouble;
        float quotient = (float)(aFloat / aDouble);
        System.out.println("float: " + aFloat);
        System.out.println("double: " + aDouble);
        System.out.println("sum: " + sum);
        System.out.println("quotient: " + quotient);
    }



}
