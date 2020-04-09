package LeetCode;

/*
Given an integer array nums with all positive numbers and no duplicates,
find the number of possible combinations that add up to a positive integer target.

A number in the array can be used multiple times in the combination.
Different orders are counted as different combinations.

Example

Example1
Input: nums = [1, 2, 4], and target = 4
Output: 6
Explanation:
The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]

Example2
Input: nums = [1, 2], and target = 4
Output: 5
Explanation:
The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
 */

public class LintCodeBackpackVI {
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            dp[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeBackpackVI solu = new LintCodeBackpackVI();
        System.out.println(solu.backPackVI(new int[]{1, 2}, 4));
    }
}
