package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {

        //一个装线程的队列
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);

        Runnable task0=()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"~~~");
            }
        };
        queue.add(task0);

        //手动创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,10,4, TimeUnit.MINUTES,queue);

        Runnable task=()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"执行了多线程了"+i);
            }
        };

        poolExecutor.execute(task);
    }

}
