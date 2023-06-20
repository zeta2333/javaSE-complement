package usts.pycro.thread.singleton;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-20 10:09 PM
 */
public class BankTest {

    static Bank b1;
    static Bank b2;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> b1 = Bank.getInstance());
        Thread t2 = new Thread(() -> b2 = Bank.getInstance());
        t1.start();
        t2.start();

        // 插队
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);
    }
}


// 单例，饿汉式
class Bank {
    private static volatile Bank instance;

    private Bank() {

    }

    // 实现线程安全的方法1
    // public static synchronized Bank getInstance() { //同步监视器为当前类的对象，唯一，线程安全
    //     if (instance == null) {
    //         try {
    //             Thread.sleep(1000);
    //         } catch (InterruptedException e) {
    //             throw new RuntimeException(e);
    //         }
    //         instance = new Bank();
    //     }
    //     return instance;
    // }

    // 实现线程安全的方法2
    // public static Bank getInstance() { // 同步监视器为当前类的对象，唯一，线程安全
    //     synchronized (Bank.class) {
    //         if (instance == null) {
    //             try {
    //                 Thread.sleep(1000);
    //             } catch (InterruptedException e) {
    //                 throw new RuntimeException(e);
    //             }
    //             instance = new Bank();
    //         }
    //     }
    //     return instance;
    // }


    // 实现线程安全的方法3，相比1和2，效率更高，为了避免指令重排，需要将instance声明为volatile
    // 双重检验锁
    public static Bank getInstance() { // 同步监视器为当前类的对象，唯一，线程安全
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}