package easy;

import java.util.Random;

public class PassByRefOrValue {

    /**
     * A very interesting difference and speaks to Java's
     * pass-by-value and array-is-an-object-reference concepts.
     */


    public static void assignEntireArray(int[] values, int n) {
        Random generator = new Random();
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(n);
        }
        values = numbers;
    }

    public static void assignEachElement(int[] values, int n) {
        Random generator = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = generator.nextInt(n);
        }
    }

    public static void printArray(int[] values) {
        for (int i : values) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        printArray(values);

        assignEntireArray(values, 100);
        printArray(values);

        assignEachElement(values, 100);
        printArray(values);
    }

}
