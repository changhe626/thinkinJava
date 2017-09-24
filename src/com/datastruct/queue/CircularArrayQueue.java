package com.datastruct.queue;

/**
 * Created by zk on 2017/9/24.
 * 作用: com.datastruct.queue.
 * 循环数组实现队列的方式
 */
public class CircularArrayQueue implements  QueueADT {


    @Override
    public boolean enqueue(Object element) {
        return false;
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public boolean first() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
