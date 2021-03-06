package thread.book2.char4;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 线程的优先级.案例
 */
public class Priority {
    private static volatile  boolean notStart=true;
    private static volatile  boolean notEnd=true;

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority=i<5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "thread" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart=false;
        TimeUnit.SECONDS.sleep(10);
        notEnd=false;

        for (Job job : jobs) {
            System.out.println("优先级是:"+job.priority+",次数是"+job.jobCount);
        }
    }



    static class Job implements Runnable{
        private int priority;

        private long jobCount;

        Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }

    /**
     * Java线程中的Thread.yield( )方法，译为线程让步。顾名思义，
     * 就是说当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，
     让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。

     yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，
     从而让其它具有相同优先级的等待线程获取执行权；但是，并不能保

     证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；
     也有可能是当前线程又进入到“运行状态”继续运行！
     */


}
