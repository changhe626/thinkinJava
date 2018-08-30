package thread.example.demo2;

public class Demo8 {

    public static void main(String[] args) throws InterruptedException {

        Demo8Task task = new Demo8Task();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("1"+thread.isInterrupted());
        System.out.println("2"+thread.isInterrupted());
        System.out.println("3"+thread.isInterrupted());


    }

}

class Demo8Task implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println("i="+i);
        }
    }
}
