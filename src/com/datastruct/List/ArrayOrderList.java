package com.datastruct.List;

import java.util.Iterator;

/**
 * Created by zk on 2017/9/25.
 * 作用: com.datastruct.List.
 */
public class ArrayOrderList implements  OrderedListADT{


    @Override
    public boolean add(Object element) {
        return false;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object first() {
        return null;
    }

    @Override
    public Object last() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
