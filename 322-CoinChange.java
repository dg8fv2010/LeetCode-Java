package LeetCode;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */

import java.util.Arrays;

public class CoinChange {
    int rst = 0;

    // https://www.cnblogs.com/grandyang/p/5138186.html
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        this.rst = Integer.MAX_VALUE;
        helper(coins, coins.length - 1, amount, 0);
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }

    public void helper(int[] coins, int start, int target, int cnt) {
        if (start < 0) {
            return;
        }
        if (target % coins[start] == 0) {
            this.rst = Math.min(this.rst, cnt + target / coins[start]);
            return;
        }

        for (int i = target / coins[start]; i >= 0; i--) {
            if (cnt + i >= this.rst - 1) {
                break;
            }
            helper(coins, start - 1, target - i * coins[start], cnt + i);
        }
    }

    // 超时
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        this.rst = Integer.MAX_VALUE;
        search(coins, amount, coins.length - 1, 0);
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }

    public void search(int[] coins, int amount, int cur, int cnt) {
        if (amount == 0) {
            this.rst = Math.min(this.rst, cnt);
            return;
        }
        if (amount < 0) {
            return;
        }

        for (int i = cur; i >= 0; i--) {
            if (cnt + 1 > this.rst) {
                break;
            }
            if (amount - coins[i] < 0) {
                continue;
            }
            search(coins, amount - coins[i], i, cnt + 1);
            //if (this.rst > 0) {
            //    break;
            //}
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CoinChange solu = new CoinChange();
        System.out.println(solu.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solu.coinChange(new int[]{2}, 3));
        System.out.println(solu.coinChange(new int[]{1, 2147483647}, 2));
        System.out.println(solu.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
