package com.innerclass;

/**
 * Created by zk on 17-10-22.自定义一个队列，接口的内部实现
 * 作用: 内部类的迭代器，这种形式
 */
public class Sequence {

    private Object[] items;
    private int next=0;

    public Sequence(int size) {
        items=new Object[size];
    }
    public void add(Object x){
        if(next<items.length){
            items[next++]=x;
        }
    }

    /**
     * 使用内部类，构建了一个迭代器
     * 结构上更加的优雅
     */
    private class SequenceSelector implements Selector{
        private int i=0;

        @Override
        public boolean end() {
            return i==items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i<items.length){
                i++;
            }
        }
    }

    public Selector selector(){
        return  new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i+3);
        }
        //获取一个迭代遍历
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.err.println(selector.current());
            selector.next();
        }
    }


}
