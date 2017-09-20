package com.datastruct.stack;

import jdk.nashorn.internal.parser.Token;

import java.util.StringTokenizer;

/**
 * Created by zk on 2017/9/20.
 * 作用: com.datastruct.stack.
 */
public class PostfixEvaluator {
    private final char ADD='+',SUB='-',MUL='*',DIV='/';
    private ArrayStack stack;

    public PostfixEvaluator() {
        this.stack = new ArrayStack();
    }

    public int evaluate(String expr) {
        int op1,op2,result=0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);
        while (tokenizer.hasMoreTokens()){
            token=tokenizer.nextToken();
            if(isOperator(token)){
                op2=Integer.parseInt(String.valueOf(stack.pop()));
                op1=Integer.parseInt(String.valueOf(stack.pop()));
                result=evalSingOp(token.charAt(0),op1,op2);
                stack.push(new Integer(result));
            }else{
                stack.push(new Integer(Integer.parseInt(token)));
            }
        }
        return  result;
    }

    private int evalSingOp(char c, int op1, int op2) {
        int result=0;
        switch (c){
            case ADD:
                result=op1+op2;
                break;
            case SUB:
                result=op1-op2;
                break;
            case MUL:
                result=op1*op2;
                break;
            case DIV:
                result=op1/op2;
                break;
        }
        return result;
    }

    private boolean isOperator(String token) {
        return token.equals("+")||token.equals("-") ||token.equals("*")||token.equals("/");
    }
}
