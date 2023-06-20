package usts.pycro.thread;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-05 9:27 PM
 */
public class PrintNumTest {
    public static void main(String[] args) {
        // 调用匿名子类
        new Thread(() -> {
            for (int i = 1; i <= 100; ++i) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }).start();
        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        }.start();
        new Thread(() -> System.out.println("Hello")).start();
    }
}
