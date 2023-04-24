package usts.pycro.api.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 11:49 AM
 */
public class OptionalTest {
    @Test
    public void test1() {
        String meal = "点外卖";
        meal = null;
        Optional<String> optional = Optional.ofNullable(meal);
        String m = optional.orElse("去食堂");
        System.out.println("午饭：" + m.toString());
    }

    @Test
    public void test2() {
        String str = "Pycro".repeat(3);
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.get());
    }
}
