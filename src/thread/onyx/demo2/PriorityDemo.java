package thread.onyx.demo2;

public class PriorityDemo {
    public static void main(String[] args) {
        System.out.println("默认的县城优先级别是:"+Thread.currentThread().getPriority());

        PriorityTask task = new PriorityTask();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(9);
        thread1.start();
        thread2.start();


    }


}


class PriorityTask  implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            System.out.println(Thread.currentThread().getName()+"-----"+i);
        }
    }
}
