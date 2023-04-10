package usts.pycro.features._switch;

import org.junit.Test;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 10:24 AM
 */
public class SwitchTest {
    @Test
    /**
     * -> 替代break,实现防穿透
     * 一个case后面多个情况可以用","分隔
     */
    public void test1() {
        WeekDay day = WeekDay.FRI;
        int res = switch (day) {
            case MON -> 1;
            case TUE, WED, THR -> 2;
            case FRI -> 3;
            default -> throw new RuntimeException("What day is today?" + day);
        };
        System.out.println(res);
    }

    @Test
    /**
     * yield 返回指定数据，结束switch结构
     * return会跳出当前方法，yield只会跳出当前switch语句
     */
    public void test2() {
        WeekDay day = WeekDay.FRI;
        int res = switch (day) {
            case MON -> {
                yield 1;
            }
            case TUE, WED, THR -> {
                yield 2;
            }
            case FRI -> {
                yield 3;
            }
            default -> {
                System.out.println("值不匹配");
                yield 4;
            }
        };
        System.out.println(res);
    }

}

enum WeekDay {
    MON, TUE, WED, THR, FRI, SAT, SUN;
}