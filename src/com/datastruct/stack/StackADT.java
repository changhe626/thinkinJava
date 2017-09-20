package com.datastruct.stack;

/**
 * stack.
 */
public interface StackADT {

    boolean push(Object element);

    Object pop();

    Object peek();

    boolean isEmpty();

    int size();
}
