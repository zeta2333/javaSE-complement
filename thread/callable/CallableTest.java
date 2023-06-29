package usts.pycro.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-29 11:22 AM
 * 与之前的方式的对比:与Runnable方式的对比的好处
 * > call()可以有返回值，更灵活
 * > call()可以使用throws的方式处理异常，更灵活
 * > Callable使用了泛型参数，可以指明具体的call()的返回值类型，更灵活
 * 有缺点吗?
 * 如果在主线程中需要获取分线程call()的返回值，则此时的主线程是阻塞状态的。
 */
public class CallableTest {
    public static void main(String[] args) {
        printNum printNum = new printNum();
        // 用FutureTask封装一下
        FutureTask<Integer> futureTask = new FutureTask<>(printNum);
        new Thread(futureTask).start();

        try {
            Integer sum;
            sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class printNum implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
            Thread.sleep(1000);
        }
        return sum;
    }
}
