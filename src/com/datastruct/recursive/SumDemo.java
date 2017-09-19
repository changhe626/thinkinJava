package com.datastruct.recursive;

/**
 * Created by zk on 2017/9/19.
 * 简单的递归例子
 */
public class SumDemo {

    public static void main(String[] args){
        System.out.println(getSum(3));
        System.out.println(getSum2(3));
    }


    /**
     * 求和的递归调用,不过数字太大有可能溢出内存
     * @param i
     * @return
     */
    public static int getSum(int i){
        if(i==1){
            return 1;
        }else{
            return i+getSum(i-1);
        }
    }

    /**
     * 方法2:
     * 求和用循环
     */
    public static int getSum2(int i){
        int sum=0;
        for (int j = 1; j <= i; j++) {
            sum+=j;
        }
        return sum;
    }

}
