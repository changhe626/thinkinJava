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
    public ArrayBag(int initialCapacity) throws UnsupportedOperationException {
        count=0;
        //对容量的大小进行判断,不能超过int最大值的一半
        if(initialCapacity>(Integer.MAX_VALUE/2)){
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
        //重新进行赋值的引用
        contents=lager;
    }

    /**
     * 记得抛出异常!!!
     * @return
     * @throws UnsupportedOperationException
     * 这里也可以不进行异常的抛出,进行判断,如果是空的袋子就直接返回null也是可以的,这样
     * 在外面进行调用的时候就不用进行try-catch,以及异常的处理了
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

       /* 2.进行所有元素的移动,往前移动一下,最后一个元素位置进行置空,zk
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
        //我认为的写法是,避免重复赋值,性能的浪费,当然了不能这样写,
        //这样写就会造成了原来的袋子的数据的不存在了....还是要按照书上的来写,要新建一个
        /*Iterator iterator=target.iterator();
        if(iterator.hasNext()){
            Object tmp=iterator.next();
            //进行是否存在的判断,存在就放进去,否则就不放,节省空间
            if(!contains(tmp)){
                add(tmp);
            }
        }
        return this;*/

        //书上的做法是,直接新建一个袋,把两个全部放进去,我自己把容量加了上去
        BagADT bagADT= new ArrayBag(count+target.size());
        for (int i = 0; i < count; i++) {
            bagADT.add(contents[i]);
        }
        Iterator iterator=target.iterator();
        while(iterator.hasNext()){
            bagADT.add(iterator.next());
        }
        return  bagADT;
    }

    @Override
    public boolean contains(Object element) {
        //1.我的写法
        /*boolean flag=false;
        for (int i = 0; i < contents.length; i++) {
            if(element.equals(contents[i])){
                flag=true;
            }
        }
        return flag;*/

        //2.书中写法是,进行下标的查找,是一个意思的.
        int search=NOT_FOUND;
        for (int i = 0; i < contents.length; i++) {
            if(element.equals(contents[i])){
                search=i;
            }
        }
        return  (search!=NOT_FOUND);

    }

    @Override
    public boolean equal(BagADT bag) {
       /* boolean flag=false;
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
        return flag;*/
       //不能够使用变成字符串来比较,因为是无顺序的,所以就算是相同的元素但是书序不同也不同,我的思路有问题.

        //直接进行地址的比较,相同就直接返回true了.zk
        if(this==bag){
            return  true;
        }

        //书中的写法是
        //注意对以前的参数进行保存,使用副本的形式进行数据的比较
        boolean flag=false;
        ArrayBag bag1 = new ArrayBag(count);
        ArrayBag bag2 = new ArrayBag(bag.size());
        bag1.addAll(this);
        bag2.addAll(bag);
        if(bag1.size()==bag2.size()){
            Iterator iterator = bag1.iterator();
            while(iterator.hasNext()){
                Object tmp=iterator.next();
                //同时进行元素的删除
                bag1.remove(tmp);
                bag2.remove(tmp);
            }
            //同时为空
            if(bag1.isEmpty() && bag2.isEmpty()){
                flag=true;
            }
        }
        return  flag;
    }

    @Override
    public boolean isEmpty() {
        //1.进行多步骤的判断 zk
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
