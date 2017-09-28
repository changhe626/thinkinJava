package com.datastruct.tree;

import java.util.Iterator;

/**
 * Created by zk on 2017/9/27.
 * 作用: com.datastruct.tree.
 */
public class BinaryTree implements BinaryTreeADT {
    private int count;
    private BinaryTreeNode root;

    public BinaryTree() {
        count=0;
        root=null;
    }

    public BinaryTree(Object element) {
        count=1;
        root=new BinaryTreeNode(element);
    }

    public BinaryTree(BinaryTreeNode element,BinaryTree leftSubtree,BinaryTree rightSubtree) {
        root=new BinaryTreeNode(element);
        count=1;
        if(leftSubtree!=null){
            count=count+leftSubtree.size();
            root.left=leftSubtree.root;
        }else{
            root.left=null;
        }

        if(rightSubtree!=null){
            count=count+rightSubtree.size();
            root.right=rightSubtree.root;
        }else{
            root.right=null;
        }
    }

    @Override
    public void removeLeftSubtree() {
        if(root.left!=null){
            count=count-root.left.numChildren()-1;
        }
        root.left=null;
    }

    @Override
    public void removeRightSubtree() {
        if(root.right!=null){
            count=count-root.right.numChildren()-1;
        }
        root.right=null;
    }

    /**
     * 全部置空
     */
    @Override
    public void removeAllElements() {
        root=null;
        count=0;
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
    public boolean contains(Object targetElement) {
        return false;
    }

    @Override
    public boolean find(Object targetElement) {
        BinaryTreeNode current=root;
        BinaryTreeNode temp=current;
        if(!(current.element.equals(targetElement)) && current.left!=null){
            current=findAgain(targetElement,current.left);
        }
        if(!(current.equals(targetElement))){
            current=temp;
        }
        if(!current.element.equals(targetElement) && current.right!=null){
            current=findAgain(targetElement,current.right);
        }
        if(!current.element.equals(targetElement)){
            return false;
        }
        return true;
    }

    private BinaryTreeNode findAgain(Object targetElement, BinaryTreeNode next) {
        BinaryTreeNode current=next;
        if(!next.element.equals(targetElement)){
            next=findAgain(targetElement,next);
        }
        if(!next.equals(targetElement)){
            next=current;
        }
        if(!next.element.equals(targetElement) && next.right!=null){
            next=findAgain(targetElement,next.right);
        }
        return  next;
    }

    @Override
    public Iterator iteratorInOrder() {
        LinedQueue queue = new LinedQueue();
        inorder(root,queue);
        return queue.iterator();
    }

    private void inorder(BinaryTreeNode root, LinedQueue queue) {
        if(root!=null){
            inorder(root.left,queue);
            queue.enqueue(root.element);
            inorder(root.right,queue);
        }
    }

    @Override
    public Iterator iteratorPreOrder() {
        return null;
    }

    @Override
    public Iterator iteratorPostOrder() {
        return null;
    }

    @Override
    public Iterator iteratorLevelOrder() {
        return null;
    }
}
