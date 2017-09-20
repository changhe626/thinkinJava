package com.datastruct.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

/**
 * Created by zk on 2017/9/20.
 * 堆栈进行计算
 */
public class Postfix {

    public static void main(String[] args){
        String expression,again;
        int result;
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PostfixEvaluator evaluator = new PostfixEvaluator();
            do{
                System.out.println("enter a valid postfix expression");
                expression=in.readLine();
                System.out.println("expression"+expression);
                result=evaluator.evaluate();
                System.out.println("result"+result);
                again=in.readLine();
                System.out.println("again"+again);
            }while(again.equalsIgnoreCase("y"));
        }catch (Exception IOException){
            System.out.println("input reproted");
        }
    }


}
