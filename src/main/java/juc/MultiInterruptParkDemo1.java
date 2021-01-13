package juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author jiao
 * @date 2021年01月13日
 */
public class MultiInterruptParkDemo1 {

    public static volatile boolean flag = true;

    public static void main(String[] args) {
        ThreadDemo04 t4 = new ThreadDemo04();
        t4.start();
        t4.interrupt();
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
