package LeetCode;

/*
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Example
Example 1

Input:
List = [1,2,3,4]
k = 2
target = 5
Output: 2
Explanation: 1 + 4 = 2 + 3 = 5
Example 2

Input:
List = [1,2,3,4,5]
k = 3
target = 6
Output: 1
Explanation: There is only one method. 1 + 2 + 3 = 6
 */

public class LintCodekSum {
    public int kSum(int[] A, int K, int target) {
        int n = A.length;
        int[][][] dp = new int[n + 1][K + 1][target + 1];

        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                for (int t = 0; t <= target; t++) {
                    dp[i][k][t] = dp[i - 1][k][t];
                    if (k > 0 && t >= A[i - 1]) {
                        dp[i][k][t] += dp[i - 1][k - 1][t - A[i - 1]];
                    }
                }
            }
        }

        return dp[n][K][target];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodekSum solu = new LintCodekSum();
        System.out.println(solu.kSum(new int[]{1, 2, 3, 4}, 2, 5));
        System.out.println(solu.kSum(new int[]{1, 2, 3, 4, 5}, 3, 6));
    }
}
