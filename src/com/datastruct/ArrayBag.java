package com.datastruct;

import java.util.Iterator;
import java.util.Random;

/**
 * 袋子的实现类
 */
public class ArrayBag  implements  BagADT{

    private  static  Random rand=new Random();
    //默认长度
    private  final int DEFAULT_CAPACITY=100;
    private  final int NOT_FOUND=-1;

    //定义长度
    private  int count;
    private  Object[] contents;

    /**
     * 默认构造函数
     */
    public ArrayBag() {
        count=0;
        contents=new Object[DEFAULT_CAPACITY];
    }

    /**
     * 定义了多少长度的构造函数
     * @param initialCapacity
     */
    public ArrayBag(int initialCapacity) {
        count=0;
        //对容量的大小进行判断
        if(initialCapacity>Integer.MAX_VALUE){
            throw  new UnsupportedOperationException("容量过大,暂时不支持");
        }else{
            contents=new Object[initialCapacity];
        }
    }


    @Override
    public void add(Object element) {
        //首先进行容量是否足够的判断
        //使用size(),或者conut都行
        if(size()==contents.length){
            //扩容
            expandCapacity();
        }
        contents[count++]=element;
    }

    /**
     * 进行容量的扩展,重新赋值
     */
    private void expandCapacity() {
        //容量扩大两倍,  contents.length*2
        Object[] lager=new Object[count*2];
        for (int i = 0; i < contents.length; i++) {
            lager[i] = contents[i];
        }
    }

    /**
     * 记得抛出异常!!!
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public Object removeRandom() throws UnsupportedOperationException{
        //1.空的不能删除,抛出异常
        if(size()<=0){
            throw  new UnsupportedOperationException("袋子是空的不能够进行删除操作");
        }
        //2.进行非空判断
        int nextInt = rand.nextInt(count);
        Object target=contents[nextInt];

        //1.书中的方法,进行前面置空
        contents[nextInt]=contents[nextInt-1];
        contents[nextInt-1]=null;

       /* 2.进行所有元素的移动,往前移动一下,我写的,最后一个元素位置进行置空
        for (int i = nextInt; i < contents.length-1; i++) {
            contents[i]=contents[i+1];
        }
        contents[contents.length-1]=null;
        */

        count--;
        return target;
    }


    @Override
    public boolean remove(Object element) {
        boolean flag=false;
        //1.进行非空的判断校验
        if(count>0){
            for (int i = 0; i < contents.length; i++) {
                if(element.equals(contents[i])){
                    flag=true;
                    //进行数组元素的移动,最后一个置空
                    for (int j = i; j <= contents.length; j++) {
                        contents[j]=contents[j+1];
                    }
                    contents[count-1]=null;
                    count--;
                    break;
                 }
            }
        }
        return flag;
    }


    @Override
    public void addAll(BagADT bag) {
        //获取其迭代器
        Iterator iterator = bag.iterator();
        if (iterator.hasNext()) {
            //不存在就添加进去
            Object tmp=iterator.next();
            if(!contains(tmp)){
                add(tmp);
            }
        }
    }

    @Override
    public BagADT union(BagADT target) {
        return null;
    }

    @Override
    public boolean contains(Object element) {
        boolean flag=false;
        for (int i = 0; i < contents.length; i++) {
            if(element.equals(contents[i])){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public boolean equal(BagADT bag) {
        boolean flag=false;
        //首先进行长度的判断
        if(contents.length==bag.size()){
            //全部取出变成一个字符串,进行比较
            StringBuilder sb = new StringBuilder();
            Iterator iterator = iterator();
            if(iterator.hasNext()){
                sb.append(iterator.next());
                sb.append(",");
            }

            StringBuilder sb2 = new StringBuilder();
            Iterator iterator2 = bag.iterator();
            if(iterator2.hasNext()){
                sb2.append(iterator2.next());
                sb2.append(",");
            }

            if(sb.equals(sb2)){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public boolean isEmpty() {
        //1.进行多步骤的判断
        /*if(count==0){
            return false;
        }else{
            return true;
        }*/
        //2.一步搞定
        return  count==0;
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
