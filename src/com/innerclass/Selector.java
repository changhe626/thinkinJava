package com.innerclass;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 * 自定义迭代器的借口
 */
public interface Selector {

    boolean end();
    Object current();
    void next();
}
