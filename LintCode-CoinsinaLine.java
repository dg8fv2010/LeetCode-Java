package LeetCode;

/*
There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left.
The player who take the last coin wins.

Could you please decide the first play will win or lose?

Have you met this question in a real interview?
Yes
Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

Challenge
O(n) time and O(1) memory
 */

public class LintCodeCoinsinaLine {
    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] == false || !dp[i - 2] == false);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeCoinsinaLine solu = new LintCodeCoinsinaLine();
        System.out.println(solu.firstWillWin(1));
        System.out.println(solu.firstWillWin(2));
        System.out.println(solu.firstWillWin(3));
        System.out.println(solu.firstWillWin(4));
        System.out.println(solu.firstWillWin(5));
    }
}
