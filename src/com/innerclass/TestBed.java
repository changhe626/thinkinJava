package com.innerclass;

public class TestBed {

    private static int i=4;

    private int j=3;


    public void f(){
        System.out.println("this is the f function");
    }

    public static class Tester{
        public static void main(String[] args) {
            new TestBed().f();
            //拥有外面的private 属性.
            System.out.println(i);
            System.out.println(new TestBed().j);
        }
    }
}
