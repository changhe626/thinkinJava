package com.datastruct.stack;

import java.util.NoSuchElementException;

/**
 * Created by zk on 2017/9/20.
 * 作用: com.datastruct.stack.
 * 数组的实现方式,暂未完成
 */
public class ArrayStack implements StackADT {
    private int count;
    private Object[] contents;

    public ArrayStack() {
        count=0;
        contents=new Object[100];
    }

    @Override
    public boolean push(Object element) {
        if(count>=99){
            //没有进行扩容操作
            return false;
        }
        contents[count]=element;
        count++;
        return true;
    }

    @Override
    public Object pop() throws  NoSuchElementException {
        if(count<=0){
            throw new NoSuchElementException();
        }
        Object temp=contents[count];
        contents[count]=null;  //置空
        count--;
        return temp;
    }

    @Override
    public Object peek() throws NoSuchElementException{
        if(count<=0){
            throw new NoSuchElementException();
        }
        Object temp=contents[count];
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public int size() {
        return count;
    }
}
