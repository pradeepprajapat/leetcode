package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
* Given an array of integers nums and an integer target,
* return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*
* */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] out = {0, 1};
        assert Arrays.equals(new TwoSum2().twoSum(a, 9), out);

        int[] a1 = {3, 2, 4};
        int[] out1 = {1, 2};
        assert Arrays.equals(new TwoSum2().twoSumUnsortedArray(a1, 6), out1);

        int[] a2 = {3, 3};
        int[] out2 = {0, 1};
        assert Arrays.equals(new TwoSum2().twoSumUnsortedArray(a2, 6), out2);

        int[] a3 = {1, 3, 4, 2};
        int[] out3 = {2, 3};
        assert Arrays.equals(new TwoSum2().twoSumUnsortedArray(a3, 6), out3);

        assert Arrays.equals(new TwoSum2().twoSumUnsortedArrayOptimal(a3, 6), out3);
    }

    //this only works on sorted array
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int op[] = new int[2];
        //since its guranteed to have solutions, I did this check.
        // Else it could be while we haven't iterated complete array
        while (nums[left] + nums[right] != target) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        op[0] = left;
        op[1] = right;
        return op;
    }

    public int[] twoSumUnsortedArray(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> valueList = map.get(nums[i]);

            if (valueList == null) {
                valueList = new ArrayList();
            }
            valueList.add(i);
            map.put(nums[i], valueList);
        }

        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {

                if (map.get(rem).size() == 1 && map.get(rem).get(0) != i) {
                    secondIndex = map.get(rem).get(0);
                    firstIndex = i;
                    break;
                }
                //find first non matching
                for (int x : map.get(rem)) {
                    if (x != i) {
                        secondIndex = x;
                        firstIndex = i;
                        break;
                    }
                }
            }
            if (firstIndex != secondIndex) {
                break;
            }
        }
        int[] op = {firstIndex, secondIndex};
        return op;
    }

    public int[] twoSumUnsortedArrayOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int op[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                op[0] = numMap.get(target - nums[i]);
                op[1] = i;
                break;
            }
            numMap.put(nums[i], i);
        }


        return op;
    }
}
