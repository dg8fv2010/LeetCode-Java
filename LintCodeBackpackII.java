package LeetCode;

/*
There are n items and a backpack with size m. Given array A representing the size of each item and array V representing the value of each item.

What's the maximum value can you put into the backpack?

Example
Example 1:

Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
Output: 9
Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9
Example 2:

Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
Output: 10
Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10
Challenge
O(nm) memory is acceptable, can you do it in O(m) memory?

Notice
A[i], V[i], n, m are all integers.
You can not split an item.
The sum size of the items you want to put into backpack can not exceed m.
Each item can only be picked up once
 */

public class LintCodeBackpackII {
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                dp[i][w] = dp[i - 1][w];
                if (w >= A[i - 1]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - A[i - 1]] + V[i - 1]);
                }
            }
        }

        int rst = 0;
        for (int i = 0; i <= m; i++) {
            rst = Math.max(rst, dp[n][i]);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeBackpackII solu = new LintCodeBackpackII();
        System.out.println(solu.backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        System.out.println(solu.backPackII(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));
    }
}
