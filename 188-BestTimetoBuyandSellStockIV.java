package LeetCode;

/*
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */

public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k > n) {
            int rst = 0;
            for (int i = 1; i < n; i++) {
                rst += Math.max(0, prices[i] - prices[i - 1]);
            }
            return rst;
        }

        int[][] dp = new int[n + 1][2 * k + 1 + 1];
        dp[0][1] = 0;
        for (int i = 2; i <= 2 * k + 1; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * k + 1; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (i > 1 && j > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for (int j = 2; j <= 2 * k + 1; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
                if (i > 1 && j > 2 && dp[i - 1][j - 2] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2] + prices[i - 1] - prices[i - 2]);
                }
            }
        }

        int rst = Integer.MIN_VALUE;
        for (int i = 1; i <= 2 * k + 1; i += 2) {
            rst = Math.max(rst, dp[n][i]);
        }
        return rst;
    }
}
