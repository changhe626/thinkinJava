package thread.onyx.demo;

public class ThreadDemo5 implements  Runnable{
    private int num=0;

    public ThreadDemo5() {
        num++;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadDemo5()).start();
    }
}
