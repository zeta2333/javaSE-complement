package usts.pycro.features.stream;

import org.junit.Test;
import usts.pycro.features.reference.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 5:46 PM
 */
public class StreamAPITest1 {

    //1.筛选与切片
    @Test
    public void test1() {
        List<Customer> list = CustomerFactory.getCusomterList(10);
        Stream<Customer> stream = list.stream();

        //filter(Predicate p)—— 接收lambda.从流中排除某些元素
        stream.filter(cus -> cus.getAge() > 25 && cus.getName().charAt(0) > 'h').forEach(System.out::println);
        System.out.println("*******************************");

        //limit(n)——截断流，使其元素不超过指定数量
        //报错，因为stream己经执行了终止操作，就不可以再调用其它的中间操作或终止操作了。
        list.stream().filter(cus -> cus.getAge() > 25).limit(2).forEach(System.out::println);
        System.out.println("*******************************");

        //skip(n)
        //跳过元素，返回一个扔掉了前n个元素的流，若流中元不足n个，则返回一个空流。与limit互补
        list.stream().skip(5).forEach(System.out::println);
        System.out.println("*******************************");

        //distinct()—筛选，通过流所生成元的hashCode()和equals()去除重复元素
        list.stream().distinct().forEach(System.out::println);
    }

    //2.映射
    @Test
    public void test2() {
        //map(Function f)：接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素。
        //练习：转换为大写
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //方式一：lambda
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //方式二：方法引用
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("*******************************");

        //练习：获取姓名大于h的客户。
        List<Customer> clist = CustomerFactory.getCusomterList(10);
        clist.stream().filter(cus -> cus.getName().charAt(0) > 'h').forEach(System.out::println);
        System.out.println("*******************************");

        //练习：获取姓名大于h的客户的姓名(先获取姓名，然后过滤)
        //方式1：
        clist.stream().filter(cus -> cus.getName().charAt(0) > 'h').map(Customer::getName).forEach(System.out::println);
        //方式2：
        clist.stream().map(Customer::getName).filter(name -> name.charAt(0) > 'h').forEach(System.out::println);
    }


    //3.排序
    @Test
    public void test3() {
        //sorted()——自然排序
        Integer[] arr = new Integer[]{2, 23, 3, 56, 3687, 3, 15, 312, 3891, 565893, 18762};
        String[] arr1 = new String[]{"GG", "DD", "VV", "AA", "TT", "XX", "EE"};

        Arrays.stream(arr).sorted().forEach(System.out::println);
        System.out.println("*******************************");
        Arrays.stream(arr1).sorted().forEach(System.out::println);
        System.out.println(Arrays.toString(arr));
        System.out.println("*******************************");
        //因为Customer没有实现Comparable接口，所以报错
        //List<Customer> list = CustomerFactory.getCustomerList(10);
        //list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com〕—— 定制排序(需要实现Comparable接口)
        List<Customer> list = CustomerFactory.getCusomterList(10);
        list.stream().sorted((c1, c2) -> c1.getAge() - c2.getAge()).forEach(System.out::println);
        System.out.println("*******************************");

        //对字符串从大到小进行排序
        Arrays.stream(arr1).sorted((s1, s2) -> -s1.compareTo(s2)).forEach(System.out::println);
        Arrays.stream(arr1).sorted(String::compareTo).forEach(System.out::println);
    }
}

