package usts.pycro.features.stream;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-01 8:04 AM
 */
public class StreamTest {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        Arrays.stream(arr)
                .filter(num -> num % 6 == 0)
                .forEach(System.out::println);
    }
}
