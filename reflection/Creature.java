package usts.pycro.reflection;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 9:07 AM
 */
public interface Creature {
    default void act(){
        System.out.println(123);
    };
}
