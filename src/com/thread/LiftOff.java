package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements  Runnable {

    @Override
    public void run() {
        System.out.println("任务致欣了");
    }

    public static void main(String[] args) {
        LiftOff off = new LiftOff();
        new Thread(off).start();


        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(off);

        }
    }
}
