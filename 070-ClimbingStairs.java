package LeetCode;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (this.map.containsKey(n)) {
            return this.map.get(n);
        }
        int rst = 0;
        if (n == 1) {
            rst = 1;
        } else if (n == 2) {
            rst = 2;
        } else {
            rst = climbStairs(n - 2) + climbStairs(n - 1);
        }
        this.map.put(n, rst);
        return rst;
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
