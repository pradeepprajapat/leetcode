package easy;

import java.util.Arrays;

/*
* Given an array nums containing n distinct numbers in the range [0, n],
* return the only number in the range that is missing from the array.
*
Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
* 2 is the missing number in the range since it does not appear in nums.
* */
public class MissingNumber {
    public static void main(String[] args) {
        int a[] = {3, 0, 1};
        assert new MissingNumber().missingNumber(a) == 2;

        int a1[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assert new MissingNumber().missingNumber(a1) == 8;

        int a2[] = {0, 1};
        assert new MissingNumber().missingNumber(a2) == 2;
    }

    /*
     * we will use the fact that sum of first n +ve numbers = n*(n+1)/2
     */
    public int missingNumber(int[] nums) {
        int actualSum = Arrays.stream(nums).parallel().sum();

        /** this is faster than streams-
         * https://www.baeldung.com/java-streams-vs-loops
         * for(int n: nums){ actualSum+=n;}
         */
        int sum = nums.length * (nums.length + 1) / 2;

        return sum - actualSum;
    }
}
