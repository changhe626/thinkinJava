package thread.book2.char0_3;

public class VoliatileDemo {
    private static volatile int tmp=0;

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    tmp++;
                    System.out.println(tmp);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    tmp++;
                    System.out.println(tmp);
                }
            }
        });

        thread.start();
        thread2.start();

    }
}
