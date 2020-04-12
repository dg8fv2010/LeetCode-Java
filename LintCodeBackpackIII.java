package LeetCode;

/*
Question
Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m.
What’s the maximum value can you put into the backpack?
Notice
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 15.

 */

public class LintCodeBackpackIII {
    public int backPackIII(int[] A, int[] V, int m) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = -1;
        }

        int rst = 0;
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                dp[i][w] = dp[i - 1][w];
                if (w >= A[i - 1]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i][w - A[i - 1]] + V[i - 1]);
                }
//                int k = 1;
//                while (w >= k * A[i - 1]) {
//                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - k * A[i - 1]] + k * V[i - 1]);
//                    k++;
//                }
                rst = Math.max(rst, dp[i][w]);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeBackpackIII solu = new LintCodeBackpackIII();
        System.out.println(solu.backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
    }
}
