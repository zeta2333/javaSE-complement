package usts.pycro.features.stream;

import org.junit.Test;
import usts.pycro.features.reference.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 5:29 PM
 */
public class StreamAPITest {
    @Test
    //创建Stream方式一：通过集合
    public void test1() {
        List<Customer> customers = CustomerFactory.getCusomterList(10);
        customers.forEach(System.out::println);

        Stream<Customer> stream = customers.stream();
        Stream<Customer> stream1 = customers.parallelStream();

        System.out.println(stream);
        System.out.println(stream1);
    }

    @Test
    //创建Stream方式二：通过数组Arrays.stream()
    public void test2() {
        Integer[] arr = {1, 2, 3, 4, 5};

        Stream<Integer> stream = Arrays.stream(arr);

        int[] arr2 = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(arr2);

    }

    @Test
    //创建Stream方式三：通过Stream的of()
    public void test3() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
    }
}
