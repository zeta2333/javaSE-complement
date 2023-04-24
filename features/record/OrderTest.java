package usts.pycro.features.record;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 11:09 AM
 */
public class OrderTest {
    @Test
    public void test1() {
        Order order1 = new Order(1001, "OrderAA");
        //toString
        System.out.println(order1);
        //getter
        System.out.println(order1.orderId());
        System.out.println(order1.orderName());
        Order order2 = new Order(1001, "OrderAA");
        System.out.println(order2.equals(order1));

        Set<Order> set = new HashSet<>();
        set.add(order1);
        set.add(order2);
        System.out.println(set);
    }

    @Test
    public void test2() {
        Order1 o1 = new Order1(1002, "OrderBB");
        //toString
        System.out.println(o1);
        //getter
        System.out.println(o1.orderId());
        System.out.println(o1.orderName());

        Order1 o2 = new Order1(1002, "OrderBB");
        System.out.println(o1.equals(o2));
        Set<Order1> set = new HashSet<>();
        set.add(o1);
        set.add(o2);
        System.out.println(set);
    }

    @Test
    public void test3() {
        Class<Order1> clazz = Order1.class;
        System.out.println(clazz.getSuperclass());
    }
}
