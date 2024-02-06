package medium;

/*
* Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

* */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] i = {-2,1};
        int[] i1 = {-2,-1};
        int[] i2 = {8,-19,5,-4,20};
        int[] i3 = {8,-19,1,-4,25};
        int[] i4 = {-1,1,2,1,-1,2,-3};
        System.out.println(getWithSlidingWindow(i));
        System.out.println(getWithSlidingWindow(input));
        System.out.println(getWithSlidingWindow(i1));
        System.out.println(getWithSlidingWindow(i2));
        System.out.println(getWithSlidingWindow(i3));
        System.out.println(getWithSlidingWindow(i4));//
         assert getWithSlidingWindow(i4) ==5;
    }
    ///Users/pradeep/Library/Java/JavaVirtual
    // Machines/openjdk-19.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ I
    // DEA CE.app/Contents/lib/idea_rt.jar=60674:/Applications/IntelliJ IDEA CE.app/Contents/bin
    // -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8
    // -classpath /Users/pradeep/IdeaProjects/leetcode/TwoSum/out/production/TwoSum:/Users/pradeep/IdeaProjects/leetcode
    // /TwoSum/lib/groovy-datetime-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-astbuilder-4.0.2.jar:
    // /Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-cli-picocli-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/
    // TwoSum/lib/groovy-ant-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-cli-commons-4.0.2.jar:
    // /Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-contracts-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-console-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-dateutil-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-docgenerator-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-jmx-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-jsr223-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-groovydoc-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-json-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-groovysh-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-macro-library-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-nio-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-macro-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-sql-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-ginq-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-templates-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-swing-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-test-junit5-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-toml-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-testng-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-test-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-typecheckers-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groo
    // vy-xml-4.0.2.jar:/Users/pradeep/IdeaProjects/leetcode/TwoSum/lib/groovy-servlet-4.0.2.jar medium.MaxSubArray java -ea medium

    private static int option1(int[] nums) {
        int maxSub = nums[0];
        int preFix = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (maxSub < 0 && preFix < 0) {
                    maxSub = 0;
                }
                maxSub = maxSub + nums[j];
                preFix = nums[i];
                if (maxSub + nums[j] > 0) {
                    maxSub += nums[j];
                } else {
                    maxSub = 0;
                }
            }
        }
        return maxSub;
    }

    /*
     * this is using kadane's algo
     * */
    private static int option2(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        //[-2, 1, -3, 4, -1, 2, 1, -5, 4
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    /*
     * this is using sliding window algo
     * */
    private static int option3(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        //[-2, 1, -3, 4, -1, 2, 1, -5, 4
        for (int i = 1; i < nums.length; i++) {
            curSum = curSum + nums[i];
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }

        }
        return maxSum;
    }

    //[-2,1]
    //[8,-19,5,-4,20]; 21
    //{-1,1,2,1}; 4
    private static int getWithSlidingWindow(int[] nums) {
        int currMax = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currMax = currMax + nums[i];
            maxSum = Math.max(currMax, maxSum);

            if(currMax <= 0){
                currMax =0;
            }
        }
        return maxSum;
    }

    public int maxSubArrayLeetCode(int[] nums) {
        if(nums == null || nums.length  == 0){
            return Integer.MIN_VALUE;
        }


        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i=0;
        while(i < nums.length) {
            sum += nums[i];
            max = max< sum ? sum : max;
            sum = sum < 0 ? 0:sum;
            i++;
        }

        return max;
    }
}
