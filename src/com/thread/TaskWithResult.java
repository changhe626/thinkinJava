package com.thread;

import java.util.concurrent.*;

public class TaskWithResult implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("这是有返回值的");
        return "123";
    }


    public static void main(String[] args) {
        TaskWithResult task = new TaskWithResult();
        ExecutorService pool = Executors.newCachedThreadPool();

        Future submit = pool.submit(task);


        System.out.println(submit.isDone());
        try {
            Object o = submit.get();
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
