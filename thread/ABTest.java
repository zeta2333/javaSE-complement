package usts.pycro.thread;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-05 10:32 PM
 */
public class ABTest {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        B b = new B(a);
        b.start();
    }
}

class A extends Thread {
    @Override
    public void run() {
        System.out.println("线程A的run...");
    }
}

class B extends Thread {
    private A a;

    public B(A a) {
        super(a);
    }
}