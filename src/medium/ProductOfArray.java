package medium;


import java.util.Arrays;
import java.util.stream.Collectors;

/*
* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
* option 1, iterate left to right and right to left. and multiply except itself to last number
* pre=  [1,1,2,6]
* post= [24,12,4,1]
* output= pre * post
* output =[24,12,8,6]
* Output: [24,12,8,6]
* ** option 2:, store one instead of pre array, which will have last multiplied value. and in second pass from left, use same output array and multiply
*  with temp variable post
* pre=1,2,3
* output=[1,1,2,6]
* post=1,4,12,24
* output=[24,12,8,6]
*
*
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
* */
public class ProductOfArray {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};

        System.out.println(Arrays.stream(option1(input)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(option2(input)).boxed().collect(Collectors.toList()));
    }

    public static int[] option1(int[] nums) {
        int answer[] = new int[nums.length];
        int preArray[] = new int[nums.length];
        int postArray[] = new int[nums.length];

        preArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            preArray[i] = preArray[i - 1] * nums[i - 1];
        }
        postArray[nums.length - 1] = 1;
        for (int i = nums.length - 2; i > -1; i--) {
            postArray[i] = postArray[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < preArray.length; i++) {
            answer[i] = preArray[i] * postArray[i];
        }
        return answer;
    }

    public static int[] option2(int[] nums) {
        int answer[] = new int[nums.length];
        int post = 1;
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        post = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            answer[i] = answer[i] * post;
            post *= nums[i];
        }
        return answer;
    }
}
