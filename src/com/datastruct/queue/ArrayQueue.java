package com.datastruct.queue;

import java.security.Principal;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zk on 2017/9/24.
 * 作用: com.datastruct.queue.
 */
public class ArrayQueue  implements  QueueADT{
    //不需要两个,一个就够了
    private static int head;
    private Object[] contents;

    public ArrayQueue() {
        head=-1;
        contents=new Object[100];
    }


    @Override
    public boolean enqueue(Object element) {
        if(head>99){
            throw new RuntimeException();
        }
        head++;
        contents[head]=element;
        return true;
    }

    @Override
    public Object dequeue() {
        if(!isEmpty()){
            Object tmp=contents[head];
            contents[head]=null;
            head--;
            return tmp;
        }else{
            return null;
        }
    }

    @Override
    public boolean first() {
        return head==0;
    }

    @Override
    public boolean isEmpty() {
        return head==-1;
    }

    @Override
    public int size() {
        return head==-1?0:(head+1);
    }

    @Override
    public String toString() {
        return "ArrayQueue{}";
    }
}
