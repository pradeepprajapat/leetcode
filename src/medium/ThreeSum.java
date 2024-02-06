package medium;

import easy.MinInRotatedSubArray;

import java.util.*;
import java.util.stream.Collectors;

/*
*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
* such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
* */
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a1 = {0, 0, 0};
        int[] a2 = {-1, 0, 1};
        int[] a3 = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};//-4,-3,-2,-1,-1,0,0,1,2,3,4
        int[] a4 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        new ThreeSum().threeSum(a);// Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        new ThreeSum().threeSum(a1);//Arrays.asList(Arrays.asList(0, 0, 0));
        new ThreeSum().threeSum(a2);//-1,0,1
        new ThreeSum().threeSum(a3);//[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        new ThreeSum().threeSum(a4);//[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
        new ThreeSum().threeSumOptimal(a4);//[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //make it 2sum problem?
        HashMap<Integer, List<Integer>> mapWithIndex = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> listToAdd = mapWithIndex.getOrDefault(nums[i], new ArrayList<>());
            listToAdd.add(i);
            mapWithIndex.put(nums[i], listToAdd);
        }
        //[-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2]
        List<List<Integer>> op = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> indexes = mapWithIndex.getOrDefault(-(nums[i] + nums[j]), new ArrayList<>(0));
                boolean foundInMap = false;
                for (int n : indexes) {
                    if (n != i && n != j) {
                        foundInMap = true;
                        break;
                    }
                }
                if (foundInMap) {
                    List<Integer> listToAdd = Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j]));
                    if (op.stream().filter(l -> listToAdd.containsAll(l)).collect(Collectors.toList()).isEmpty()) {

                        op.add(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                    }


                }
            }
        }
        //TODO: hanlde duplicate triplet result
        System.out.println(op);
        return op;
    }

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> opList = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    opList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left<right && nums[left-1]== nums[left]){
                        left++;
                    }
                }
            }
        }
        System.out.println(opList);
        return opList;
    }
}
