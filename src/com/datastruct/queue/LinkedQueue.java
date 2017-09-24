package com.datastruct.queue;

import com.datastruct.bag.LinearNode;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Created by zk on 2017/9/22.
 * 作用: com.datastruct.queue.
 */
public class LinkedQueue  implements QueueADT{
    private LinearNode  head;
    private LinearNode tail;
    private  static int count=0;

    public LinkedQueue() {
        head=null;
        tail=null;
    }

    @Override
    public boolean enqueue(Object element) {
        LinearNode node = new LinearNode();
        if(head==null){
            tail=node;
        }else{
            head.setNext(node);
        }
        tail=node;
        count++;
        return true;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw  new NoSuchElementException();
        }
        Object element = tail.getElement();
        LinearNode next = tail.getNext();
        tail=next;
        count--;
        return element;
    }

    @Override
    public boolean first() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return "LinkedQueue{}";
    }
}
