package LeetCode;

/*
There are n coins in a line.
Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
The player with the larger amount of money wins.

Could you please decide the first player will win or lose?

Example
Given array A = [3,2,2], return true.

Given array A = [1,2,4], return true.

Given array A = [1,20,4], return false.
 */

public class LintCodeCoinsinaLineIII {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(values[i] - dp[i + 1][j], values[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeCoinsinaLineIII solu = new LintCodeCoinsinaLineIII();
        System.out.println(solu.firstWillWin(new int[]{3, 2, 2}));
        System.out.println(solu.firstWillWin(new int[]{1, 2, 4}));
        System.out.println(solu.firstWillWin(new int[]{1, 20, 4}));
    }
}
