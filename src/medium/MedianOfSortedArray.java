package medium;

import java.util.Arrays;

public class MedianOfSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        int[] c = {1, 2};
        int[] d = {1};
        int[] e = {3, 5, 10, 12, 20};
        int[] f = {1, 4, 5, 13};
        int[] g = {10, 12, 14, 16, 18, 20};
        int[] h = {2, 3, 5, 8};
        int[] i = {10, 11, 12, 14, 16, 18};
        int[] j = {2, 3, 5, 8, 9};
        System.out.println(getMedian(a, b));
        // System.out.println(getMedian1(a, b));
        System.out.println(getMedian(c, d));
        // System.out.println(getMedian1(c, d));
        System.out.println(getMedian(g, h));
        //System.out.println(getMedian1(g, h));
        System.out.println(getMedianByBst(g, h));
        //   System.out.println(getMedian(i, j));
        System.out.println(getMedianByBst(i, j));
    }

    private static double getMedian1(int[] a, int[] b) {
        int temp[] = new int[a.length + b.length];
        int j = 0, k = 0;
        for (int i = 0; i < a.length + b.length; i++) {
            if (k < a.length && a[k] <= b[Math.min(j, b.length - 1)]) {
                temp[i] = a[k];
                k++;
            } else if (j < b.length) {
                temp[i] = b[j];
                j++;
            }
        }

        if (temp.length % 2 != 0) {
            return temp[temp.length / 2];
        }
        return (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2.0;
    }

    private static double getMedian(int[] a, int[] b) {
        int temp[] = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            temp[a.length + i] = b[i];
        }
        Arrays.sort(temp);
        if (temp.length % 2 != 0) {
            return temp[temp.length / 2];
        }
        return (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2.0;
    }

    private static double getMedianByBst(int a[], int b[]) {

        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        int n1 = a.length, n2 = b.length;
        int length = n1 + n2;
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            if (mid1 < n1) {
                r1 = a[mid1];
            }
            if (mid2 < n2) {
                r2 = b[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = a[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = b[mid2 - 1];
            }
            if (l1 <= r2 && l2 <= r1) {
                if (length % 2 == 1) {
                    return Math.max(l1, l2);
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
