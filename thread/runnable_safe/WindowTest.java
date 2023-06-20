package usts.pycro.thread.runnable_safe;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-13 12:57 PM
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("窗口1");
        Window w2 = new Window("窗口2");
        Window w3 = new Window("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread {
    static int ticket = 100;

    public Window(String name) {
        super(name);
    }

    public Window() {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 使用集成Thread的方法实现多线程，this(可以表示w1,w2,w3)不唯一，线程仍处于不安全状态
            // 使用类.class对象
            synchronized (Window.class) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + ticket);
                    --ticket;
                } else break;
            }

        }
    }
}