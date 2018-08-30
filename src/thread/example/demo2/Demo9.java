package thread.example.demo2;

public class Demo9 extends Thread{

    public static void main(String[] args)  {
        Demo9 demo9 = new Demo9();
        demo9.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo9.interrupt();

        System.out.println("this is the end ");
    }


    @Override
    public void run() {
        for (int i = 0; i < 60000; i++) {
             if(isInterrupted()){
                 /*System.out.println("已经是停止状态了,我要退出");
                 break;*/
                 //2.
                 try {
                     throw new InterruptedException();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             System.out.println(i);
        }
        //1.
        System.out.println("这里表示for还在继续执行");
    }
}


