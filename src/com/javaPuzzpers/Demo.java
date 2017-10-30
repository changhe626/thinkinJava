package com.javaPuzzpers;

import org.junit.Test;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.io.Closeable;
import java.io.IOException;

/**
 * Created by zk on 2017/10/30.
 * 作用: com.javaPuzzpers.
 */
public class Demo {


    /**
     * NaN的测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Double.NaN);  //NaN
        System.out.println(Double.NaN==0.0/0/0);  //false
        System.out.println(Double.NaN==Double.NaN); //false
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println(0.0/0/0);   //NaN
        System.out.println(Float.NaN+1);  //NaN
    }


    @Test
    public void test(){
        int j=0;
        for (int i = 0; i < 100; i++) {
             j=j++;
             //等价于下面的代码
//             int tmp=j;
//             j=j+1;
//             j=tmp;
        }
        System.out.println(j);
    }


    /**
     * 一直不停的循环,因为边界问题,所以一直循环下去了
     */
    @Test
    public void test2(){
        int end=Integer.MAX_VALUE;
        int start=Integer.MIN_VALUE;
        int count=0;
        for (int i = start; i <=end; i++) {
             count++;
        }
        System.out.println(count);
    }


    /**
     * 不停的循环下去,精度问题
     */
    @Test
    public void test3(){
        int start=20000000;
        int count=0;
        for (float f = start; f < start+50; f++) {
                count++;
        }
        System.out.println(count);
    }


    /**
     * 异常的不正常的返回
     */
    @Test
    public void test4(){
        System.out.println(descision());

    }

    private boolean descision() {
        try{
            return true;
        }catch (Exception e){
            System.out.println("ds");
        }finally {
            return false;
        }
    }


    /**
     * 可以关闭的进行关闭的封装
     * @param c
     */
    private static void closeIgnoringException(Closeable c){
        if(c!=null){
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
                //进行异常的处理...
            }
        }
    }


    /**
     * 注意正则中的点表示任一字符的意思,其他字符还是需要进行转义的
     */
    @Test
    public void test5(){
        String s=this.getClass()+"";
        System.out.println(s.replaceAll(".","/"));



        System.out.println("null".hashCode()); //3392903
    }


}
