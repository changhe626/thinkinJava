package com.datastruct.List;

/**
 * Created by zk on 2017/9/24.
 * 作用: com.datastruct.List.
 */
public interface UnorderedListADT  extends  ListADT{
    boolean addToFront(Object element);

    boolean addToRear(Object element);

    boolean addAfter(Object element,Object target);

}
