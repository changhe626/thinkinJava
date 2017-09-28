package com.datastruct.tree;

import java.util.Iterator;

/**
 * Created by zk on 2017/9/27.
 * 作用: com.datastruct.tree.
 * 树的接口
 */
public interface BinaryTreeADT {
    void removeLeftSubtree();
    void removeRightSubtree();
    void removeAllElements();
    boolean isEmpty();
    int size();
    boolean contains(Object targetElement);
    boolean find(Object targetElement);
    String toString();
    Iterator  iteratorInOrder();
    Iterator  iteratorPreOrder();
    Iterator  iteratorPostOrder();
    Iterator  iteratorLevelOrder();

}
