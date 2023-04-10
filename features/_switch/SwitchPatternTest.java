package usts.pycro.features._switch;

import org.junit.Test;
import usts.pycro.singleton.User;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 10:37 AM
 */
public class SwitchPatternTest {
    @Test
    public void test1() {
        Object o = "123";
        System.out.println(formatter(o));
        o = 123;
        System.out.println(formatterSwitchPattern(o));
        o = new User();
        System.out.println(formatterSwitchPattern(o));
    }

    /**
     * JDK17之前
     *
     * @param o
     * @return
     */
    static String formatter(Object o) {
        String formatted = "unknown";
        if (o instanceof Integer i) {
            formatted = "int " + i;
        } else if (o instanceof Long l) {
            formatted = "long " + l;
        } else if (o instanceof Double d) {
            formatted = "double " + d;
        } else if (o instanceof String s) {
            formatted = "String " + s;
        }
        return formatted;
    }

    static String formatterSwitchPattern(Object o) {
        return switch (o) {
            case Integer i -> "int " + i;
            case Long l -> "long " + l;
            case Double d -> "double " + d;
            case String s -> "String " + s;
            default -> "unknown" + o;
        };
    }
}
