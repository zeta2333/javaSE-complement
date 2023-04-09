package usts.pycro.features.stream;

import usts.pycro.features.reference.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-09 5:24 PM
 */
public class CustomerFactory {
    public static List<Customer> getCusomterList(int length) {
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String name = String.valueOf((char) (int) (Math.random() * 26 + 'a'));
            int age = (int) (Math.random() * 20 + 20);
            String gender = i % 2 == 0 ? "male" : "female";
            list.add(new Customer(name, age, gender));
        }
        return list;
    }
}
