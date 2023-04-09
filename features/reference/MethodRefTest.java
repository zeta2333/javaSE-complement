package usts.pycro.features.reference;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 3:58 PM
 */
public class MethodRefTest {
    @Test
    public void test1() {
        //1.匿名对象
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("hello");

        //2.lambda
        Consumer<String> con2 = s -> {
            s += " ";
            System.out.println(s);
        };
        con2.accept("hello");

        //3.方法引用
        Consumer<String> con3 = System.out::println;
        con3.accept("hello");
    }

    @Test
    public void test2() {
        Function<String, Long> func1 = new Function<String, Long>() {
            @Override
            public Long apply(String s) {
                return Long.parseLong(s);
            }
        };
        //lambda
        Function<String, Long> func2 = s -> Long.parseLong(s);

        //methodRef
        Function<String, Long> func3 = Long::parseLong;
        System.out.println(func3.apply("1234567890"));
    }

    @Test
    public void test3() {
        Comparator<String> com1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        //2.lambda
        Comparator<String> com2 = (s1, s2) -> s1.compareTo(s2);

        //3.methodRef
        Comparator<String> com3 = String::compareTo;
        System.out.println(com3.compare("abc", "abd"));
    }

    @Test
    public void test4() {
        Customer cus1 = new Customer("Pycro", 20, "male");
        Function<Customer, String> func1 = new Function<Customer, String>() {
            @Override
            public String apply(Customer customer) {
                return customer.getName();
            }
        };

        //lambda
        Function<Customer, String> func2 = customer -> customer.getName();

        //methodRef
        Function<Customer, String> func3 = Customer::getName;
        System.out.println(func3.apply(cus1));
    }
}
