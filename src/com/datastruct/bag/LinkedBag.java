package com.datastruct.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 链表的实现方式,2017年9月19日09:05:26
 */
public class LinkedBag implements BagADT{

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
        contents.setNext(node);  //只需要设置以前的旧节点是新建的节点的下一个就行了
        contents=node;        //替换为最新的一个节点,就有了全部的节点了
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
            result=current.getElement();//获得要去掉的那个节点
            previous.setNext(current.getNext());  //改变下一的指向
        }
        count--;  //个数减去1
        return result;
    }


    @Override
    public boolean remove(Object element) throws  NoSuchElementException{
        if(count==0){
            throw new NoSuchElementException("集合是空的");
        }
        boolean found=false;
        LinearNode previous,current;
        Object result;
        //这就是第一个元素的时候
        if(contents.getElement().equals(element)){
            result=contents.getElement();
            contents=contents.getNext(); //直接指向下一个的引用
            found=true;
        }else{
            //不是第一个的时候
            previous=contents;
            current=contents.getNext();
            for (int i = 1; i <=count && !found; i++) {
                 if(current.getElement().equals(element)){
                     found=true;
                 }else{
                     //继续往下进行遍历
                     previous=contents;
                     current=current.getNext();
                 }
            }
            //在找到后,true的时候执行,改变指向,同时减去个数,没有删除就返回false,不抛出异常
            if(found){
                result=current.getElement();
                previous.setNext(current.getNext());
                count--;
            }
        }
        return found;
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
        boolean flag=false;
        if(count==0){
            return flag;
        }
        LinearNode next=contents;
        while(next.getNext()!=null){
            if(next.getElement().equals(element)){
                flag= true;
            }
        }
        return  flag;
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
        //这里之能够这样写
        return new LinkedIterator(count,contents);
    }

    //迭代器的实现接口的三个方法
    //这里不能在本类中实现接口,会对原始数据进行改变,造成了影响,还必须用一个新的类


    @Override
    public String toString() {
        Iterator iterator = iterator();
        StringBuilder sb = new StringBuilder();
        while(iterator.hasNext()){
            sb.append(iterator.next());
        }
        return sb.toString();
    }


    /**
     * 两个中不同的元素,放在一个袋子中,返回
     * @param bag
     * @return
     */
    public static  LinkedBag difference(LinkedBag bag){


        return null;
    }

    /**
     * 两个袋子中相同的元素,放在一起返回
     * @param bag
     * @return
     */
    public static LinkedBag intersection(LinkedBag bag){


        return null;
    }





}





class LinkedIterator implements Iterable<LinkedBag>,Iterator {

    private int count;
    private LinearNode contents;

    public LinkedIterator(int count, LinearNode contents) {
        this.count = count;
        this.contents = contents;
    }

    @Override
    public boolean hasNext() {
        boolean flag=false;
        if(count==0){
            return flag;
        }
        if(contents!=null){
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
        }else{
            throw new UnsupportedOperationException("");
        }
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不能够进行删除");
    }

    @Override
    public Iterator<LinkedBag> iterator() {
        return this;
    }
}
