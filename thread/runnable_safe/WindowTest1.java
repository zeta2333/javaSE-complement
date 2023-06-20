package usts.pycro.thread.runnable_safe;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-13 12:57 PM
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        new Thread(w1, "窗口2").start();
        new Thread(w1, "窗口1").start();
        new Thread(w1, "窗口3").start();
    }
}

class Window1 implements Runnable {
    int ticket = 10000;
    boolean isEnd = false;

    public Window1() {
    }

    @Override
    public void run() {
        while (!isEnd) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            show();
        }
    }

    public synchronized void show() { // 此时同步监视器为：this，唯一，线程安全
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售票：" + ticket);
            --ticket;
        } else isEnd = true;
    }
}