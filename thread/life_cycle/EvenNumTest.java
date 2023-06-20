package usts.pycro.thread.life_cycle;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-13 10:56 AM
 */
public class EvenNumTest {
    public static void main(String[] args) {
        printNum t1 = new printNum("线程1");
        printNum t2 = new printNum("线程2");
        printNum t3 = new printNum("线程3");
        printNum t4 = new printNum("线程4");
        // 修改t1的名称
        t1.setName("线程一");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        // 获取t1的优先级
        System.out.println(t1.getPriority());

        // 当前线程修改名称
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i + "*****************");
            }
            if (i == 20) {
                try {
                    // 调用t1.join()后，主线程进入阻塞状态，直到t1执行结束，主线程才结束阻塞，继续执行
                    // 插队
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        t3.start();
        t4.start();
        // System.out.printf("%s是否存活：%b \n", t1.getName(), t1.isAlive());
    }

}

class printNum extends Thread {
    public printNum() {
    }

    public printNum(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     throw new RuntimeException(e);
            // }
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
            // if (i % 20 == 0) {
            //     Thread.yield();
            // }
        }
    }
}