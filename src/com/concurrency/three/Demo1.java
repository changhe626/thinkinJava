package com.concurrency.three;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zk on 2017/11/19.
 * 作用: com.concurrency.third.
 * final private  类型的set在本类中依旧可以继续添加元素的
 *
 */
public class Demo1 {

    private final Set<String> sets=new HashSet<String>();

    public Demo1() {
        sets.add("1");
        sets.add("5");
        sets.add("r");
        sets.add("d");
    }

    public boolean isContain(String name){
        return sets.contains(name);
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1);

        System.out.println(demo1.isContain("1"));
        Set<String> sets2 = demo1.sets;
        System.out.println(sets2);
        sets2.add("ssss");
        System.out.println(sets2);


    }
}
