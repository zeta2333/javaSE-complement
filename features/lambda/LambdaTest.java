package usts.pycro.features.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 11:36 AM
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };
        r1.run();
        //lambda表达式的写法
        Runnable r2 = () -> System.out.println("Hello Lambda");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int res = com1.compare(12, 21);
        System.out.println(res);

        //lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int res2 = com2.compare(35, 33);
        System.out.println(res2);

        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int res3 = com3.compare(123, 456);
        System.out.println(res3);
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4};//类型推断
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 97);
        map.put("b", 98);
        map.put("c", 99);
        map.put("d", 100);
        var entrySet = map.entrySet();
        map.forEach(System.out::printf);
    }

    @Test
    public void test4() {
        Comparator<Integer> com1 = (o1, o2) ->
        {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int res = com1.compare(45, 67);
        System.out.println(res);

        //函数型接口
        //方法引用：Function<Integer, String> func = Integer::toHexString;
        Function<Integer, String> func = input -> Integer.toHexString(input);
        String hex = func.apply(256);
        System.out.printf("0x%s\n", hex);
    }
}
