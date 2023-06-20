package usts.pycro.thread;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-05 8:50 PM
 * 创建一个分线程1，用于遍历100以内的偶数
 */
public class EvenNumTest extends Thread {
    public static void main(String[] args) throws InterruptedException {
        // EvenNum t1 = new EvenNum(1);
        // EvenNum t2 = new EvenNum(0);
        // t1.start();
        /*
        不能让已经start的线程再次执行start操作，否则抛出异常IllegalThreadStateException
         */
        // t1.start();
        // t2.start();
        //
        // Thread.sleep(5);
        // for (int i = 1; i <= 100; ++i) {
        //     if (i % 2 == 0) {
        //         System.out.println(Thread.currentThread().getName() + " : " + i);
        //     }
        // }
        PrintNum p = new PrintNum();
        new Thread(p).start();
        new Thread(p).start();
    }
}

class EvenNum extends Thread {

    private int arg;

    public EvenNum(int arg) {
        this.arg = arg;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
            if (i % 2 == arg) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class PrintNum implements Runnable {
    private int num;

    @Override
    public void run() {
        ++num;
        System.out.println(num);
    }
}