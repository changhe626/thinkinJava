package com.datastruct.stack;

import com.datastruct.bag.LinearNode;

import java.util.EmptyStackException;

/**
 * Created by zk on 2017/9/22.
 * 作用: com.datastruct.stack.
 * 栈的链表的实现方式
 */
public class LinkedStack implements StackADT{

    private int count;
    private LinearNode top;

    public LinkedStack() {
        count=0;
        top=null;
    }

    @Override
    public boolean push(Object element) {
        LinearNode node = new LinearNode(element);
        node.setNext(top);
        top=node;
        count++;
        return true;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Object element = top.getElement();
        top=top.getNext();
        count--;
        return element;
    }

    @Override
    public Object peek() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Object element = top.getElement();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public int size() {
        return count;
    }

    //迭代还是新一个新类来实现Iterator接口的,不然会改变原来的指向
}
