package com.datastruct.binarytree;

/**
 * Created by zk on 2017/9/28.
 * 作用: com.datastruct.binarytree.
 */
public interface BinarySearchTreeADT {
    void addElement(Comparable element);
    Comparable removeElement(Comparable targetElement);
    void removeAllOccurrences(Comparable targetElement);
    Comparable removeMin();
    Comparable removeMax();
    Comparable findMin();
    Comparable findMax();
}
