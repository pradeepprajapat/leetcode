package easy;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] input = {1, 2, 2, 4};
        int[] input1 = {1, 1};
        int[] input2 = {3, 3, 1};
        int[] i4 = {3, 2, 2};
        int[] i5 = {1, 3, 3};
        Arrays.stream(findErrorNums(input)).boxed().forEach(System.out::print);
        Arrays.stream(findErrorNums(input1)).boxed().forEach(System.out::print);
        Arrays.stream(findErrorNums(input2)).boxed().forEach(System.out::print);
        System.out.println();
        Arrays.stream(findErrorNums(i4)).boxed().forEach(System.out::print);
        System.out.println();
        Arrays.stream(findErrorNums(i5)).boxed().forEach(System.out::print);
    }

    //{3,2,2};
    public static int[] findErrorNums(int[] nums) {
        boolean isAscending = true;
        int[] op = new int[2];
        if (nums.length >= 2) {
            if (nums[0] > 1) {
                isAscending = false;
            }
        }
        ////1,3,3
        if (isAscending) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    op[0] = nums[i];
                    op[1] = i + 1;
                }
            }
            return op;
        }
        //{3,3, 1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums.length - i) {
                op[0] = nums[i];
                op[1] = nums.length - i;
            }
        }
        return op;
    }

    /*
     * this is when input is not sorted
     * */
    //[8,7,3,5,3,6,1,4]
    public static int[] findErrorNumsUnsortedInput(int[] nums) {
        int[] op = new int[2];
        int expectedSum = nums.length * (nums.length + 1) / 2; //36
       boolean seen[] = new boolean[nums.length+1];
      for(int i=0;i<nums.length;i++){
          expectedSum -= nums[i];
          if(seen[nums[i]]){
            op[0]=nums[i];
          }
          seen[nums[i]]= true;
      }
      op[1]=expectedSum+op[0];
        return op;
    }

}
