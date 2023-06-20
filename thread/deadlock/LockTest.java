package usts.pycro.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-20 11:19 PM
 */
class SaleTicket implements Runnable {
    int ticket = 100;
    // 1.创建Lock对象，需要注意对象的唯一性，建议使用static final
    // 可重入锁
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                // 2.执行lock()方法，锁定当前共享对象
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + ticket);
                    --ticket;
                } else break;
            } finally {
                // 3.执行unlock()方法，解除对象锁定
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();
        Thread t1 = new Thread(s, "窗口1");
        Thread t2 = new Thread(s, "窗口2");
        Thread t3 = new Thread(s, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}