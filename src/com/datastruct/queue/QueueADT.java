package com.datastruct.queue;

/**
 * Created by zk on 2017/9/22.
 * 作用: com.datastruct.queue.
 * /队列的接口
 */
public interface QueueADT {

    /**
     * 进入队列
     * @param element
     * @return
     */
    public boolean enqueue(Object element);

    /**
     * 从队列中删除最前面的一个元素
     * @return
     */
    public Object dequeue();

    /**
     * 检查队列最前面的那个元素
     * @return
     */
    public boolean first();

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 队列中现有元素的个数
     * @return
     */
    public int size();



}
