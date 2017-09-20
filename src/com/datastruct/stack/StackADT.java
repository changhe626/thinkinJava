package com.datastruct.stack;

/**
 * stack.
 * 其实可以实现泛型的操作,进行具体类型的保存,不用再次进行类型的强转了
 * 2017年9月20日21:10:19
 */
public interface StackADT {

    boolean push(Object element);

    Object pop();

    Object peek();

    boolean isEmpty();

    int size();
}
