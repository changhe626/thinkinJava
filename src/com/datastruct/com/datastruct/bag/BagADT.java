package com.datastruct.com.datastruct.bag;

import java.util.Iterator;


public interface BagADT {

    /**
     * 添加元素
     * @param element
     */
    void add(Object element);

    /**
     * 随机删除一个元素
     * @return
     */
    Object removeRandom();

    /**
     * 删除一个元素
     * @param element
     * @return
     */
    boolean remove(Object element);


    /**
     * 把一个袋添加到另外一个中去
     * @param bag
     */
    void addAll(BagADT bag);

    /**
     * 合并两个袋子
     * @param target
     * @return
     */
    BagADT union(BagADT target);

    /**
     * 是否包含元素
     * @param element
     * @return
     */
    boolean contains(Object element);

    /**
     * 两个袋子是否相同
     * @param bag
     * @return
     */
    boolean equal(BagADT bag);

    /**
     * 袋子是否为空的
     * @return
     */
    boolean isEmpty();

    /**
     * 袋子中有几个元素
     * @return
     */
    int size();

    /**
     * 获取其迭代器
     * @return
     */
    Iterator iterator();

    /**
     * toString方法
     * @return
     */
    String toString();


}
