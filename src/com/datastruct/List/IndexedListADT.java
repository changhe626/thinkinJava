package com.datastruct.List;

/**
 * Created by zk on 2017/9/24.
 * 作用: com.datastruct.List.
 */
public interface IndexedListADT extends  ListADT {

    boolean add(int index,Object element);

    boolean add(Object element);

    boolean set(int index,Object element);

    Object get(int index);

    int indexOf(Object element);

    Object remove(Object element);
}
