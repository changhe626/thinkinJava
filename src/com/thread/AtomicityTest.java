package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zk on 2017/10/29.
 * 作用: com.thread.
 */
public class AtomicityTest  implements  Runnable{
    private int i=0;

    public int getI() {
        return i;
    }

    private synchronized void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while(true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        pool.submit(at);
        while(true){
            int val=at.getI();
            if(val % 2 !=0){
                System.out.println(val);
                System.exit(0);
            }
        }

    }
}
