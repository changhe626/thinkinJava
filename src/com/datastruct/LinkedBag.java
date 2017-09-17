package com.datastruct;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 链表的实现方式，请自己写出来，谢谢
 */
public class LinkedBag implements BagADT {

    private  static Random random=new Random();

    private  int count;  //个数的统计

    //指向下一个节点的引用
    private LinearNode contents;

    //新建的时候全部为空的
    public LinkedBag() {
        count=0;
        contents=null;
    }

    @Override
    public void add(Object element) {
        LinearNode node = new LinearNode(element);
        contents.setNext(node);  //只需要设置下一个引用就行了
        contents=node;        //替换为最新的一个节点
        count++;
    }

    @Override
    public Object removeRandom() throws  NoSuchElementException {
        LinearNode previous,current;
        Object result=null;
        if(count==0){
            throw new NoSuchElementException("空的");
        }
        int choice=random.nextInt(count)+1;
        if(choice==1){
            result=contents.getElement();
            contents=contents.getNext();
        }else{
            previous=contents;
            for (int i = 2; i < choice; i++) {
                previous=previous.getNext();
            }
            current=previous.getNext();
            result=current.getElement();
            previous.setNext(current.getNext());
        }
        count--;
        return result;
    }


    @Override
    public boolean remove(Object element) throws  NoSuchElementException{
        if(count==0){
            throw new NoSuchElementException("集合是空的");
        }

        return false;
    }

    @Override
    public void addAll(BagADT bag) {


    }

    @Override
    public BagADT union(BagADT target) {
        LinkedBag bag = new LinkedBag();



        return null;
    }

    @Override
    public boolean contains(Object element) {
        if(count==0){
            return false;
        }
        LinearNode next=contents;
        while(next.getNext()!=null){
            if(next.getElement().equals(element)){
                return true;
            }
        }
        return  false;
    }

    @Override
    public boolean equal(BagADT bag) {
        return false;
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
    public Iterator iterator() {
        return null;
    }
}

//一个自定义的节点
class  LinearNode{
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
