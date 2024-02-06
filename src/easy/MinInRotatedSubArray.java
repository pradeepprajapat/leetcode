package easy;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Medium
 * Topics
 * Companies
 * Hint
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 */

public class MinInRotatedSubArray {
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        int[] a1 = {4, 5, 6, 7, 0, 1, 2};
        int[] a2 = {11, 13, 15, 17};
        assert new MinInRotatedSubArray().findMin(a) == 1;
        assert new MinInRotatedSubArray().findMin(a1) == 0;
        assert new MinInRotatedSubArray().findMin(a2) == 11;
        assert new MinInRotatedSubArray().findMinByBs(a2) == 11;
    }

    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                continue;
            }
            min = nums[i];
            break;
        }
        return min;
    }

    public int findMinByBs(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
