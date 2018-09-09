package thread.book2.char4;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态
 * 运行之后,在cmd中   jps,找到一个  2796  ThreadState的
 * 然后jstack 2796  查看信息
 */
public class ThreadState {

    public static void main(String[] args) {

        new Thread(new TimeWaiting(),"timewaitthread").start();

        new Thread(new Waiting(),"waitthread").start();

        //使用两个blocked线程,一个获取锁成功,一个阻塞
        new Thread(new Blocked(),"blocked-1").start();
        new Thread(new Blocked(),"blocked-2").start();

    }


    //该线程不断地睡眠
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //线程在waiting.class实例上等待
    static class Waiting implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //该线程在Blocked.class实例上加锁后,不会释放锁
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    try {
                        Blocked.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

/**
 * C:\Users\zhangke>jstack 2796
 2018-09-09 16:25:27
 Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.144-b01 mixed mode):

 "DestroyJavaVM" #15 prio=5 os_prio=0 tid=0x000000000443e000 nid=0x1900 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "blocked-2" #14 prio=5 os_prio=0 tid=0x000000001ac39800 nid=0x26ac in Object.wait() [0x000000001babf000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x00000000d60980a8> (a java.lang.Class for thread.book2.char4.ThreadState$Blocked)
 at java.lang.Object.wait(Object.java:502)
 at thread.book2.char4.ThreadState$Blocked.run(ThreadState.java:59)
 - locked <0x00000000d60980a8> (a java.lang.Class for thread.book2.char4.ThreadState$Blocked)
 at java.lang.Thread.run(Thread.java:748)

 "blocked-1" #13 prio=5 os_prio=0 tid=0x000000001ac38800 nid=0x2f40 in Object.wait() [0x000000001b9be000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x00000000d60980a8> (a java.lang.Class for thread.book2.char4.ThreadState$Blocked)
 at java.lang.Object.wait(Object.java:502)
 at thread.book2.char4.ThreadState$Blocked.run(ThreadState.java:59)
 - locked <0x00000000d60980a8> (a java.lang.Class for thread.book2.char4.ThreadState$Blocked)
 at java.lang.Thread.run(Thread.java:748)

 "waitthread" #12 prio=5 os_prio=0 tid=0x000000001abee800 nid=0xe6c in Object.wait() [0x000000001b8be000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x00000000d6095588> (a java.lang.Class for thread.book2.char4.ThreadState$Waiting)
 at java.lang.Object.wait(Object.java:502)
 at thread.book2.char4.ThreadState$Waiting.run(ThreadState.java:42)
 - locked <0x00000000d6095588> (a java.lang.Class for thread.book2.char4.ThreadState$Waiting)
 at java.lang.Thread.run(Thread.java:748)

 "Service Thread" #10 daemon prio=9 os_prio=0 tid=0x000000001abd9800 nid=0xc44 runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "C1 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x000000001aba2000 nid=0x2d50 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x000000001ab42000 nid=0x1c8c waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x000000001ab3c000 nid=0x2034 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x000000001ab16800 nid=0x18ac runnable [0x000000001b1be000]
 java.lang.Thread.State: RUNNABLE
 at java.net.SocketInputStream.socketRead0(Native Method)
 at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
 at java.net.SocketInputStream.read(SocketInputStream.java:171)
 at java.net.SocketInputStream.read(SocketInputStream.java:141)
 at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
 at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
 at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
 - locked <0x00000000d61329e0> (a java.io.InputStreamReader)
 at java.io.InputStreamReader.read(InputStreamReader.java:184)
 at java.io.BufferedReader.fill(BufferedReader.java:161)
 at java.io.BufferedReader.readLine(BufferedReader.java:324)
 - locked <0x00000000d61329e0> (a java.io.InputStreamReader)
 at java.io.BufferedReader.readLine(BufferedReader.java:389)
 at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:64)

 "Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x00000000196ba800 nid=0x1b00 waiting on condition [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001aac8800 nid=0x2fb0 runnable [0x0000000000000000]
 java.lang.Thread.State: RUNNABLE

 "Finalizer" #3 daemon prio=8 os_prio=1 tid=0x0000000004b2d000 nid=0x2e50 in Object.wait() [0x000000001a9bf000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x00000000d5f08ec8> (a java.lang.ref.ReferenceQueue$Lock)
 at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
 - locked <0x00000000d5f08ec8> (a java.lang.ref.ReferenceQueue$Lock)
 at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
 at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

 "Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000004b22000 nid=0x2be8 in Object.wait() [0x000000001a8bf000]
 java.lang.Thread.State: WAITING (on object monitor)
 at java.lang.Object.wait(Native Method)
 - waiting on <0x00000000d5f06b68> (a java.lang.ref.Reference$Lock)
 at java.lang.Object.wait(Object.java:502)
 at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
 - locked <0x00000000d5f06b68> (a java.lang.ref.Reference$Lock)
 at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

 "VM Thread" os_prio=2 tid=0x0000000019626800 nid=0x2d88 runnable

 "GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000004a48000 nid=0x1118 runnable

 "GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000004a49800 nid=0x83c runnable

 "GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000004a4b000 nid=0x1f68 runnable

 "GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000004a4c800 nid=0xd54 runnable

 "VM Periodic Task Thread" os_prio=2 tid=0x000000001abe3000 nid=0xd0 waiting on condition

 JNI global references: 33
 */
