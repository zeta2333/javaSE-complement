package usts.pycro.thread.communication;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-21 11:54 AM
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Producer(clerk, "生产者1").start();
        new Consumer(clerk, "消费者1").start();
        new Consumer(clerk, "消费者2").start();
    }
}

class Clerk {
    private int productNum = 0; // 产品数量，不超过20个

    // 生产
    public synchronized void addProduct() {
        if (productNum >= 20) {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            ++productNum;
            System.out.println(Thread.currentThread().getName() + "生产了商品，当前商品数：" + productNum);
            // 唤醒
            notifyAll();

        }
    }

    // 消费
    public synchronized void reduceProduct() {
        // 当出现两个以上消费者时，进入消费方法后需要判断产品数量，如果产品数量不小于0则需要再次判断
        if (productNum <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            --productNum;
            System.out.println(Thread.currentThread().getName() + "消费了商品，当前商品数：" + productNum);
            // 唤醒
            notifyAll();


    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk, String name) {
        this.clerk = clerk;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            // 生产
            System.out.println("生产者开始生产商品...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.addProduct();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk, String name) {
        this.clerk = clerk;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            // 消费
            System.out.println("消费者开始消费商品");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.reduceProduct();
        }

    }
}