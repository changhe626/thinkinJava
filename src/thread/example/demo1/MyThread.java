package thread.example.demo1;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Mythread"+i);
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        thread2.start();
        thread.start();
    }

}
