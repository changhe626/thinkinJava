package com.myStrictfp;

import org.junit.Test;

/**
 * Created by zk on 2017/10/19.
 * 作用: com.myStrictfp.
 */
public  strictfp class Test2 {

    @Test
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
}
