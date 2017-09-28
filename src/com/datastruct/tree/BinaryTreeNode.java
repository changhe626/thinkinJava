package com.datastruct.tree;

/**
 * Created by zk on 2017/9/27.
 * 作用: com.datastruct.tree.
 */
public class BinaryTreeNode {
    protected Object element;
    protected BinaryTreeNode left,right;

    //构造函数
    public BinaryTreeNode(Object element) {
        this.element = element;
        left=null;
        right=null;
    }

    //所有的孩子的个数
    public int numChildren(){
        int children=0;
        if(left!=null){
            children=1+left.numChildren();
        }
        if(right!=null){
            children=1+right.numChildren();
        }
        return children;
    }
}
