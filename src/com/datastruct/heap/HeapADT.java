package com.datastruct.heap;

import com.datastruct.tree.BinaryTreeADT;

/**
 * Created by zk on 2017/10/6.
 * 作用: com.datastruct.heap.
 * 堆的接口
 */
public interface HeapADT extends BinaryTreeADT{
    /**
     * 添加元素
     * @param element
     * @return
     */
    boolean addElement(Comparable element);

    /**
     * 删除元素
     * @param
     * @return
     */
    Comparable removeMin();

    /**
     * 找到最小值
     * @return
     */
    Comparable findMin();

}
