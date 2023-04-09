package usts.pycro.reflection;

import java.util.Objects;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 8:18 AM
 */
public class Person implements Creature {
    private String name;
    public int age;
    private static String info;

    public Person() {
    }

    //@Override
    //public boolean equals(Object o) {
    //    if (o instanceof Person p) {
    //        return name.equals(p.name) && age == p.age;
    //    }
    //    return false;
    //}

    @Override
    public boolean equals(Object o) {
        return o instanceof Person p
                && name.equals(p.name)
                && age == p.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
