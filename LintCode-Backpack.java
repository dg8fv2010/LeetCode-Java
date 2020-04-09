package LeetCode;

/*
Description
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Notice
You can not divide any item into small pieces.

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5],
so that the max size we can fill this backpack is 10. If the backpack size is 12.
we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

 */

public class LintCodeBackpack {

    public int backPack(int m, int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                dp[i][w] = dp[i - 1][w];
                if (w >= A[i - 1]) {
                    dp[i][w] = dp[i][w] || dp[i - 1][w - A[i - 1]];
                }
            }
        }

        int rst = 0;
        for (int w = m; w >= 0; w--) {
            if (dp[n][w]) {
                rst = w;
                break;
            }
        }
        return rst;
    }
}
