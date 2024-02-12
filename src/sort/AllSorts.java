package sort;

import java.util.Arrays;

public class AllSorts {

    public static void main(String[] args) {
        int a[] = {12, 11, 13, 5, 6};
        assert Arrays.equals(new AllSorts().insertionSort(a), new int[]{5, 6, 11, 12, 13});
        assert Arrays.equals(new AllSorts().mergeSort(a), new int[]{5, 6, 11, 12, 13});
        assert Arrays.equals(new AllSorts().mergeSort(new int[]{2, 10, 5, 0, -1, 0, 9, 1}), new int[]{-1, 0, 0, 1, 2, 5, 9, 10});
        assert Arrays.equals(new AllSorts().quickSort(new int[]{2, 10, 5, 0, -1, 0, 9, 1}), new int[]{-1, 0, 0, 1, 2, 5, 9, 10});
    }

    /*
     * Sort until left value is greater than current value ( for each value in array from i=0 to n-1)
     *Shift current with current+1, to make space for right value.
     * time: O(n^2)
     * space = O(1)
     * */
    private int[] insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int key = a[i];
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j]; //shift current to right
                j--;
            }
            a[j + 1] = key; // j+1 as j will be j-- in prev step for a[j] > key
        }
        return a;
    }

    /*
     * divide array into 2 parts,
     * sort it with merge
     * time = O(nlon)
     * space = O(n)
     * */
    private int[] mergeSort(int a[]) {
        sort(a, 0, a.length - 1);
        return a;
    }

    private void sort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r - 1) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private void merge(int a[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = a[m + 1 + i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k++] = L[i++];
        }
        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    /*
     * divide and conquer; pick any elemnet as pivot , like end element and divide around it
     * all the elements before pivot would always be less than pivot. idea is put pivot element at proper place
     * */
    private int[] quickSort(int[] a) {
        //get partition
        quickS(a, 0, a.length - 1);
        return a;
    }

    private void quickS(int[] a, int start, int end) {
        if (end < start) {
            return;
        }
        int partition = getPartition(a, start, end);
        quickS(a, start, partition - 1);
        quickS(a, partition + 1, end);
    }

    private int getPartition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        i++;
        int t = a[i];
        a[i] = pivot;
        a[end] = t;
        return i;
    }

}

