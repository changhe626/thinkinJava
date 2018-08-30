package thread.onyx.demo;

public class ThreadDemo6 {


    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        MyTask1 myTask1 = new MyTask1();
       // MyTask1 myTask2 = new MyTask1();


        Thread thread1 = new Thread(myTask1);
        Thread thread2 = new Thread(myTask1);
        thread1.setDaemon(true);
        //thread1.start();
        //thread2.start();

    }

}
