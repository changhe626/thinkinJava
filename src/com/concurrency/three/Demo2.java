package com.concurrency.three;

/**
 * Created by zk on 2017/11/19.
 * 作用: com.concurrency.third.
 * final 指向可变对象再赋值
 */
public class Demo2 {

    private static final StringBuilder sb=new StringBuilder("11,");

    public static void main(String[] args) {

        System.out.println(sb);


        sb.append("新赋值...");
        System.out.println(sb);
    }

}
