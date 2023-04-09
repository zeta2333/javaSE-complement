package usts.pycro.features.reference;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 4:49 PM
 */
public class ConstructorRefTest {
    @Test
    public void test1() {
        Supplier<Customer> sup1 = new Supplier<Customer>() {
            @Override
            public Customer get() {
                return new Customer();
            }
        };

        //方法引用
        Supplier<Customer> sup2 = Customer::new;//调用Customer中的空参构造器
        System.out.println(sup2.get());
    }

    @Test
    public void test2() {
        Function<Integer, Customer> fun1 = new Function<Integer, Customer>() {
            @Override
            public Customer apply(Integer age) {
                return new Customer(age);
            }
        };

        //方法引用
        Function<Integer, Customer> fun2 = Customer::new;//调用Customer类中参数为Integer/int的构造器
        System.out.println(fun2.apply(23));
    }

    @Test
    public void test3() {
        BiFunction<Integer, String, Customer> bif1 = new BiFunction<Integer, String, Customer>() {
            @Override
            public Customer apply(Integer age, String name) {
                return new Customer(name, age);
            }
        };

        BiFunction<String, Integer, Customer> bif2 = Customer::new;//调用Customer类中参数为Integer/int、String的构造器
        System.out.println(bif2.apply("Pycro", 23));
    }

    @Test
    public void test4() {
        //1
        Function<Integer, Customer[]> fun1 = new Function<Integer, Customer[]>() {
            @Override
            public Customer[] apply(Integer length) {
                return new Customer[length];
            }
        };
        //2
        Function<Integer, Customer[]> fun2 = Customer[]::new;
        System.out.println(fun2.apply(5).length);
    }
}
