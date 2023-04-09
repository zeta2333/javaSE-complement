package usts.pycro.features.stream;

import org.junit.Test;
import usts.pycro.features.reference.Customer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 7:16 PM
 */
public class StreamAPITest2 {

    //1.匹配、计算
    @Test
    public void test1() {
        List<Customer> list = CustomerFactory.getCusomterList(10);
        //allMatch(Predicate p)：检查是否匹配所有元素
        //练习：是否所有客户的年龄都大于30
        System.out.println(list.stream().allMatch(cus -> cus.getAge() > 25));

        //anyMatch()：检查是否至少匹配一个元素
        //练习：是否存在年龄大于25岁的客户
        System.out.println(list.stream().anyMatch(cus -> cus.getAge() > 25));
        //findFirst()：返回第一个元素
        System.out.println(list.stream().findFirst());
    }


    @Test
    public void test2() {
        List<Customer> list = CustomerFactory.getCusomterList(10);
        list.forEach(System.out::println);
        System.out.println("*******************************");

        //count()：返回流中元素的总个数
        System.out.println(list.stream().filter(cus -> cus.getAge() > 30).count());
        System.out.println("*******************************");

        //max(Comparator c):返回流中最大值
        //练习：返回最大age
        System.out.println(list.stream().map(Customer::getAge).max(Integer::compareTo));
        System.out.println("*******************************");
        //min(Comparator c):返回流中最小值
        //练习；返回最小的name
        System.out.println(list.stream().min((cus1, cus2) -> cus1.getName().compareTo(cus2.getName())));
        System.out.println(list.stream().map(Customer::getName).min(String::compareTo));

        //forEach()：内部迭代
        list.stream().forEach(System.out::println);


        //针对集合，java8添加了forEach方法
        list.forEach(System.out::println);
    }

    //2.规约reduce
    @Test
    public void test3() {
        //reduce(T identity,BinaryOperator)：可以将流中元素反复结合起来，得到一个值，返回T
        //练习1：计算1-10的自然是的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce((n1, n2) -> n1 + n2));
        System.out.println(list.stream().reduce(0, (n1, n2) -> n1 + n2));
        System.out.println(list.stream().reduce(10, (n1, n2) -> n1 + n2));
        System.out.println(list.stream().reduce(10, (n1, n2) -> Integer.sum(n1, n2)));
        System.out.println(list.stream().reduce(10, Integer::sum));
        System.out.println("*******************************");

        //练习2：计算所有客户的年龄总和
        List<Customer> clist = CustomerFactory.getCusomterList(10);
        System.out.println("所有客户年龄总和为:" + clist.stream().map(Customer::getAge).reduce(0, Integer::sum));
    }

    //3.收集
    @Test
    public void test4() {
        List<Customer> list = CustomerFactory.getCusomterList(20);
        //collector(Collector c)：将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找年龄大于35的客户，结果返回为一个List或Set
        List<Customer> collect = list.stream().filter(cus -> cus.getAge() > 35).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("*******************************");
        list.forEach(System.out::println);
        //练习2：按照客户的年龄进行排序，返回到一个新的List中
        List<Customer> collect1 = list.stream().sorted((cus1, cus2) -> cus1.getAge() - cus2.getAge()).collect(Collectors.toList());
        List<Customer> collect2 = list.stream().sorted(Comparator.comparingInt(Customer::getAge)).toList();
        System.out.println("*******************************");
        collect1.forEach(System.out::println);
    }
}
