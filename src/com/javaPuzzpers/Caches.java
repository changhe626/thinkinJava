package com.javaPuzzpers;

/**
 * Created by zk on 2017/10/30.
 * 作用: com.javaPuzzpers.
 */
public class Caches {

    //先执行的静态代码块,再执行方法
    static {
        System.out.println("开始执行静态代码块了");
        init();
    }

    private static int sum;
    public static int getSum(){
        init();
        return sum;
    }

    //再初始化变量
    private static  boolean inited=false;

    private static  synchronized   void init() {
            if(!inited){
                for (int i = 0; i < 100; i++) {
                     sum+=i;
                }
            inited=true;
            }
    }


    public static void main(String[] args) {
        System.out.println(Caches.getSum());
    }
}
