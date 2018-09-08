package thread.book2.char0_3;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    public static void main(String[] args) {

        //获取java线程关系的MXBean
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        System.out.println(bean);

        //不需要获取同步的monitor和synchronizer信息,仅获取县城和线程堆栈信息
        ThreadInfo[] allThreads = bean.dumpAllThreads(false, false);
        //遍历打印
        for (ThreadInfo allThread : allThreads) {
            System.out.println(allThread.getThreadId()+"~~"+allThread.getThreadName());
        }
        /**
         6~~Monitor Ctrl-Break
         5~~Attach Listener
         4~~Signal Dispatcher
         3~~Finalizer
         2~~Reference Handler
         1~~main
         */
    }
}
