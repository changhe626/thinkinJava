package com.datastruct.com.datastruct.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 链表的实现方式,2017年9月19日09:05:26
 */
public class LinkedBag implements BagADT,Iterable<LinkedBag>,Iterator {

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
        LinearNode previous=contents;
        while(previous.getElement()!=null){
            if(previous.getElement().equals(element)){
                previous.getNext();
            }
        }


        return false;
    }

    @Override
    public void addAll(BagADT bag) {
        Iterator iterator = bag.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }
    }

    /**
     * 新建一个bag,进行赋值,然后返回,不要对参数进行了破坏
     * @param target
     * @return
     */
    @Override
    public BagADT union(BagADT target) {
        LinkedBag bag = new LinkedBag();
        bag.addAll(this);
        bag.addAll(target);
        return bag;
    }

    /**
     * 遍历查找,比较
     * @param element
     * @return
     */
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
        boolean flag=false;
        if(count==0 && bag.size()==0){
            flag=true;
            return flag;
        }
        //进行参数的保存,备份,不然会对原来的参数造成破坏了
        BagADT bag1=new LinkedBag();
        BagADT bag2=new LinkedBag();
        bag1.addAll(this);
        bag2.addAll(bag);
        Iterator iterator = bag1.iterator();
        while (iterator.hasNext()){
            Object tmp = iterator.next();
            bag1.remove(tmp);
            bag2.remove(tmp);
        }
        //同时为空
        if(bag1.size()==0 && bag2.size()==0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public int size() {
        return count;
    }

    /**
     * 直接返回这个对象
     * @return
     */
    @Override
    public Iterator iterator() {
        return this;
    }

    //迭代器的实现接口的三个方法
    @Override
    public boolean hasNext() {
        boolean flag=false;
        if(count==0){
            return flag;
        }
        if(contents.getNext().getElement()!=null){
            flag=true;
        }
        return flag;
    }

    @Override
    public Object next() {
        if(hasNext()){
            Object element = contents.getElement();
            LinearNode next = contents.getNext();
            contents=next;  //重新进行赋值
            return element;
        }
        return null;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不能够进行删除");
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
