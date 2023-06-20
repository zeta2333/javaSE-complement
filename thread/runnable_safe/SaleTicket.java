package usts.pycro.thread.runnable_safe;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-13 12:54 PM
 *
 */
public class SaleTicket implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {// this为调用该方法的对象，是否唯一？yes
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + ticket);
                    --ticket;
                } else break;
            }

        }
    }
}

class SaleTicketTest {
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