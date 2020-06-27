package LeetCode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n + 1];
        int[] sell = new int[n + 1];
        int[] rest = new int[n + 1];
        rest[0] = 0;
        sell[0] = 0;
        hold[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i - 1]);
            rest[i] = Math.max(rest[i - 1], sell[i - 1]);
            sell[i] = hold[i - 1] + prices[i - 1];
        }
        return Math.max(sell[n], rest[n]);
    }
}
