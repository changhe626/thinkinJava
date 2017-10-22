package com.innerclass;

/**
 * Created by zk on 17-10-22.
 * 作用: com.innerclass.
 */
public class DoThis {

    void f(){
        System.err.println(" zhaojun ,this is a native menthod");
    }

    public class Inner{
        public DoThis outer(){
            return DoThis.this;
            //return new DoThis();
           // return this;   //这里的this是DoThis。Inner  不是DoThis了。
        }
    }

    public Inner inner(){
        return  new Inner();
    }

    public static void main(String[] args) {
        DoThis doThis = new DoThis();
        Inner inner = doThis.inner();
        DoThis.Inner in=doThis.inner();
        in.outer().f();
        inner.outer().f();
    }

}
