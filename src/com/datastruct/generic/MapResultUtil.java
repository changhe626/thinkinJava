package com.datastruct.generic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据key返回不同的结果集,返回其精准的类型
 */
public class MapResultUtil {
    /**
     * 储存值的map
     */
    private static Map<String,Object> map=new HashMap<String,Object>();


    /**
     * 储存其Class的map
     */
    private static Map<String,Class> clazz=new HashMap<String,Class>();

    /**
     * 放置元素
     * @param
     * @param <T>
     */
    public static<T> void add(String key,T value){
        map.put(key, value);
        clazz.put(key,value.getClass());
    }


    /**
     * @param key
     * @return
     */
    public static Map<Object, Class> get(String key){
        Object o = map.get(key);
        Class aClass = clazz.get(key);
        Map<Object, Class> map = new HashMap<Object, Class>();
        map.put(o,aClass);
        return map;
           // return aClass.cast(o);
    }


//   https://www.douyu.com/673320

}
