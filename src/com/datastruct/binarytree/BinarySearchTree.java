package com.datastruct.binarytree;

import com.datastruct.tree.BinaryTree;

/**
 * Created by zk on 2017/9/28.
 * 作用: com.datastruct.binarytree.
 */
public class BinarySearchTree extends BinaryTree implements BinarySearchTreeADT {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(Comparable element) {
        super(element);
    }

    @Override
    public void addElement(Comparable element) {

    }

    @Override
    public Comparable removeElement(Comparable targetElement) {
        return null;
    }

    @Override
    public void removeAllOccurrences(Comparable targetElement) {

    }

    @Override
    public Comparable removeMin() {
        return null;
    }

    @Override
    public Comparable removeMax() {
        return null;
    }

    @Override
    public Comparable findMin() {
        return null;
    }

    @Override
    public Comparable findMax() {
        return null;
    }
}
