package com.datastruct.bag;

//一个自定义的节点
public class  LinearNode{
    private LinearNode next;
    private Object element;

    public LinearNode() {
        next=null;
        element=null;
    }

    public LinearNode(Object element) {
        this.element = element;
        next=null;
    }

    public LinearNode getNext() {
        return next;
    }

    public Object getElement() {
        return element;
    }

    public void setNext(LinearNode next) {
        this.next = next;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}