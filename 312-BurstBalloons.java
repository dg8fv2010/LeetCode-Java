package LeetCode;

/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            A[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 1; i++) {
            dp[i][i + 1] = 0;
        }

        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                int j = i + len - 1;
                dp[i][j] = 0;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        BurstBalloons solu = new BurstBalloons();
        System.out.println(solu.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
