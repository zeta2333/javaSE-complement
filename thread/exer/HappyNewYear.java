package usts.pycro.thread.exer;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-20 5:40 PM
 */
public class HappyNewYear {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i > 0; --i) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Happy New Year!");
    }
}
