package thread.onyx.demo4;


/**
 * 死锁：是指两个或者两个以上的线程在执行的过程中，因争夺资源产生的一种互相等待现象,
 * 所有的线程都进入了第一个锁,但是进不去第二个锁,又没有办法释放
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        DeadLockTask task = new DeadLockTask();

        Thread thread = new Thread(task, "线程1");
        Thread thread2 = new Thread(task, "线程2");
        Thread thread3 = new Thread(task, "线程3");
        Thread thread4 = new Thread(task, "线程4");
        thread.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.flag=false;
        thread4.start();

    }



}


class DeadLockTask implements Runnable{
    // 定义锁  //两个锁
    private Object locka = new Object();
    private Object lockb = new Object();
    // 定义一个boolean变量，控制线程的逻辑
    public boolean flag = true;
    @Override
    public void run() {
        if( flag){   // t1
            while(true){
                synchronized (locka) {
                    System.out.println(Thread.currentThread().getName()+"if .... locka");
                    synchronized (lockb) {
                        System.out.println(Thread.currentThread().getName()+"if .... lockb");
                    }
                }
            }
        }else{       // t2
            while(true){
                synchronized (lockb) {
                    System.out.println(Thread.currentThread().getName()+"else .... lockb");
                    synchronized (locka) {
                        System.out.println(Thread.currentThread().getName()+"else .... locka");
                    }
                }
            }
        }
    }

}
