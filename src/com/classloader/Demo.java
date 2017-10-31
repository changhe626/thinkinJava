package com.classloader;

/**
 * Created by zk on 2017/10/31.
 * 作用: com.classloader.
 */
public class Demo {

    public static void main(String[] args) {
        ClassLoader loader = Demo.class.getClassLoader();
        System.out.println(loader);//sun.misc.Launcher$AppClassLoader@1a46e30
    }
}
