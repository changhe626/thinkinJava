package thread.example.demo1;

public class MyThread2  extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int i1 = (int) Math.random() * 1000;
            try {
                Thread.sleep(i1);
                System.out.println(Thread.currentThread().getName()+"~~"+i1);
                System.out.println("run="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2, "mythread");
        thread.start();
        for (int i = 0; i < 10; i++) {
            int i1 = (int) Math.random() * 1000;
            try {
                Thread.sleep(i1);
                System.out.println(Thread.currentThread().getName()+"~~"+i1);
                System.out.println("run="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
