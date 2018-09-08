package thread.book2.char0_3;

public class DeadLock {
    private static String a="A";
    private static String b="B";

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread 1  a");
                    synchronized (b){
                        System.out.println("thread 1  b");
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("thread 2 a");
                    synchronized (a) {
                        System.out.println("thread 2 b");
                    }
                }
            }
        });

        thread.start();
        thread1.start();
    }

}
