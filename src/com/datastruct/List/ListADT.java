package com.datastruct.List;

import java.util.Iterator;

/**
 * Created by zk on 2017/9/24.
 * 作用: com.datastruct.List.
 * //链表接口
 */
public interface ListADT {

    Object removeFirst();

    Object removeLast();

    Object first();

    Object last();

    boolean isEmpty();

    int size();

    Iterator iterator();

}
