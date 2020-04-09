package LeetCode;

/*
Given n items with size nums[i] which an integer array and all positive numbers.
An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is:
[7]
[1, 3, 3]
return 2
 */

public class LintCodeBackpackV {
    public int backPackV(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeBackpackV solu = new LintCodeBackpackV();
        System.out.println(solu.backPackV(new int[]{1, 2, 3, 3, 7}, 7));
    }
}
