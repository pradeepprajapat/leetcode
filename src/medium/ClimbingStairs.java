package medium;

/*
 You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
        */
public class ClimbingStairs {

    public static void main(String[] args) {
        assert new ClimbingStairs().climbStairs(3) == 3;
        assert new ClimbingStairs().climbStairs(2) == 2;
        assert new ClimbingStairs().climbStairsoption2(2) == 2;
    }

    public int climbStairs(int n) {
        //fibbinici sum, current n is sum of last 2 numbers
        if (n < 2) {
            return n;
        }
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /*
     * uses less memory
     * */
    public int climbStairsoption2(int n) {
        //fibbinici sum, current n is sum of last 2 numbers
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev2 + prev1;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}