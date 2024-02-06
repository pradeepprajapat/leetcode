package medium;

import java.util.LinkedList;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] input = {2, 0, 2};
        int[] input1 = {3, 0, 5, 0, 4, 0, 2, 0, 6, 3, 5};
        int[] input2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(getMaxWater(input));
        System.out.println(getMaxWater(input1));
        System.out.println(getMaxWater(input2));
    }

    /*
     * Time = O(n)
     *
     * */
    private static int getMaxWater(int[] a) {
        int storage = 0;
        int lMax = 0;
        int rMax = getMax(a, 1, a.length);
        for (int i = 1; i < a.length - 1; i++) {
            lMax = Math.max(a[i - 1], lMax);

            if (a[i] != rMax) {
                storage += Math.min(lMax, rMax) - a[i];
            }
            if (a[i] == rMax) {
                rMax = getMax(a, i + 1, a.length);
            }

        }
        return storage;
    }

    private static int getMax(int a[], int start, int end) {
        int m = a[start];
        for (int i = start; i < end; i++) {
            m = Math.max(a[i], m);
        }
        return m;
    }
}
