package medium;

/*
* Given an integer array nums, find a
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
* */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4};
        int[] a1 = {-2, 0, -1};
        int[] a2 = {3, -1, 4};
        int[] a3 = {3, -1, 4, 0, 5};
        int[] a4 = {3, -1, -1, 0, 1};
        assert new MaxProductSubArray().maxProduct(a) == 6;
        assert new MaxProductSubArray().maxProduct(a1) == 0;
        assert new MaxProductSubArray().maxProduct(a2) == 4;
        assert new MaxProductSubArray().maxProduct(a4) == 3;
    }

    private int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = 1;
        int currMin = 1;
        int tmp ;
        for (int i = 0; i < nums.length; i++) {
            tmp = currMax * nums[i];
            currMax = max(tmp, currMin * nums[i], nums[i]);
            currMin = min(tmp, currMin * nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
