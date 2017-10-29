package com.javaPuzzpers;

/**
 * Created by zk on
 * 2017/10/29.
 * 作用: com.javaPuzzpers.
 */
public class FloatCpmpare {

    /**
     * 比较两个float数字类型的大小.
     * @param args
     */
    public static void main(String[] args) {
        float a=1.45F;
        float b=1.45000f;
        int to = Float.valueOf(a).compareTo(b);
        System.out.println(to);
    }
}
