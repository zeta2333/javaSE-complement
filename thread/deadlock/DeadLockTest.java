package usts.pycro.thread.deadlock;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-20 10:53 PM
 */
public class DeadLockTest {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        new Thread(() -> {
            synchronized (s1) {
                System.out.println(Thread.currentThread().getName() + " get s1");
                s1.append("P");
                s2.append("6");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (s2) {
                    System.out.println(Thread.currentThread().getName() + " get s2");
                    s1.append("yc");
                    s2.append("8");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        },"线程A").start();
        new Thread(() -> {
            synchronized (s2) {
                System.out.println(Thread.currentThread().getName() + " get s2");
                s1.append("r");
                s2.append("1");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (s1) {
                    System.out.println(Thread.currentThread().getName() + " get s1");
                    s1.append("o");
                    s2.append("5");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        },"线程B").start();
    }
}
