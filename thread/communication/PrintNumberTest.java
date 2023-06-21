package usts.pycro.thread.communication;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-21 10:39 AM
 * 两个线程交替打印 1 - 100
 * wait()
 * notify()
 * notifyAll()
 * 此三个方法的使用必须在同步代码块或同步方法中
 * 此三个方法的调用者必须是同步监视器，否则会报错：IllegalMonitorStateException
 * 此三个方法声明在Object中。
 */
public class PrintNumberTest {
    public static void main(String[] args) {
        PrintNumber p = new PrintNumber();
        new Thread(p, "线程1").start();
        new Thread(p, "线程2").start();
    }
}

class PrintNumber implements Runnable {
    private int num = 1;
    private boolean isEnd;

    @Override
    public void run() {
        while (!isEnd) {
            this.printNum();
        }
    }

    public synchronized void printNum() {
        notify();
        if (num <= 100) {
            try {
                Thread.sleep(1);// 执行此方法，线程不会释放同步监视器
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":" + num++);
            try {
                wait();// 线程一旦执行此方法，就进入等待状态。同时，会释放同步监视器（锁）的调用
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else isEnd = true;
    }
}