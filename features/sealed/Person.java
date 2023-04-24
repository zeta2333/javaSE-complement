package usts.pycro.features.sealed;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 11:25 AM
 */

//Person是一个密封美，可以被指定的子类所继承，非指定的类不能继承Person美
public sealed class Person permits Student, Teacher, Worker {
}

//要求指定的子类必须是final、sealed、non-sealed三者之一
final class Student extends Person {
}

sealed class Teacher extends Person permits SeniorTeacher {
}

final class SeniorTeacher extends Teacher {
}

non-sealed class Worker extends Person {//worker类在被继承时没有任何限制
}

//class Farmer extends Person{}