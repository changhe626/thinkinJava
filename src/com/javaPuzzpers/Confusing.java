package com.javaPuzzpers;

/**
 * Created by zk on 2017/10/30.
 * 作用: 方法的精确匹配问题
 */
public class Confusing {
    public static void main(String[] args) {

            test1(new int[1]);
            test1(null);
    }


    /**
     *
     * @param object
     */
    public static void test1(Object object){

        System.out.println("这个是object方法");
    }

    /*public static void test1(Object[] obj){
        System.out.println("这是object 数组方法");
    }*/

    public static void test1(int[] arr){
        System.out.println("这是int[] 数组的方法");
    }


}
