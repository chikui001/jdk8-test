package juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 程序在输出了第一条打印语句后挂起，说明无论调用多少次LockSupport.unpark(t4)，只会提供给线程一个许可。
 */
public class MultiInterruptParkDemo2 {

    public static volatile boolean flag = true;

    public static void main(String[] args) {
        ThreadDemo04 t4 = new ThreadDemo04();
        t4.start();
        LockSupport.unpark(t4);
        LockSupport.unpark(t4);
        LockSupport.unpark(t4);
        flag = false;
    }

    public static class ThreadDemo04 extends Thread {

        @Override
        public void run() {
            while (flag) {
            }
            LockSupport.park();
            System.out.println("本打印出现在第一个park()之后");
            LockSupport.park();
            System.out.println("本打印出现在第二个park()之后");
        }
    }
}
