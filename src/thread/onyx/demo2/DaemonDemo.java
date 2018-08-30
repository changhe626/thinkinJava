package thread.onyx.demo2;

/*
 * 演示：守护线程
 * public void setDaemon(boolean on) 标记线程为一个守护线程
 * 如果非守护线程一旦结束，那么守护线程就强制终止。不管有没有运行完成。
 * 结束了,守护线程还是会再继续执行一下的,具体执行多少就不一定了. 默认的不是守护线程
 */
public class DaemonDemo {

    public static void main(String[] args) {
        DaemonTask task = new DaemonTask();
        Thread thread = new Thread(task, "张飞");
        Thread thread2 = new Thread(task, "关于");

        thread.setDaemon(true);
        thread2.setDaemon(true);

        thread.start();
        thread2.start();
        /**
         * 这里是100的时候,基本上执行全部打印的是刘备,不会打印张飞,关于
         * 但是设置为1000 的时候,就会间歇的出现张飞,关于.
         * 主线程执行完了,守护线程还执行多少真就没法确定了,
         * 有时候执行完循环,有时候不执行完循环
         */
        for (int i = 0; i < 100; i++) {
            System.out.println("这里是刘备"+i);
        }


    }
}


class DaemonTask implements  Runnable{

    @Override
    public void run() {
        for( int i = 0; i < 20; i++){
            System.out.println(Thread.currentThread().getName() + " .. " + i);
        }
    }
}