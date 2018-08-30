package thread.onyx.demo;

public class MyTask1 implements Runnable {

    private int num = 100;

    @Override
    public void run() {
            while (num > 0) {
                System.out.println("now the num is " + num+"   --"+Thread.currentThread().getName());
                num--;
            }
    }
}
