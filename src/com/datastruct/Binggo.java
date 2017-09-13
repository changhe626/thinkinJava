package com.datastruct;

/**
 * 测试类
 */
public class Binggo {

    public  static  void main(String[] args){
        final int NUM_BALLS=75;
        final int NUM_PULLS=10;

        BingBall ball;

        ArrayBag bag = new ArrayBag();
        for (int i = 0; i < NUM_BALLS; i++) {
            ball=new BingBall(i);
            bag.add(ball);
        }

        System.out.println(bag.size());

        for (int i = 0; i < NUM_PULLS; i++) {
            ball=(BingBall)bag.removeRandom();
            System.out.println(ball);
        }

    }
}
