package com.datastruct.generic;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Demo {

    @Test
   public   void test1(){
       MapResultUtil.add("1",1);
       MapResultUtil.add("2","2");
       MapResultUtil.add("3",new Demo());

        Map<Object, Class> map1 = MapResultUtil.get("3");
        Object key=null;
        Class value=null;
        for (Map.Entry<Object, Class> objectClassEntry : map1.entrySet()) {
             key = objectClassEntry.getKey();
             value = objectClassEntry.getValue();
        }
        Object cast = value.cast(key);
        System.out.println(cast);
        ((Demo)cast).test2();


    }

    public void test2(){
        System.out.println("localhost method");
    }



}
