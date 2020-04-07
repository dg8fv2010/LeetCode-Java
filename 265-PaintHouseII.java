package LeetCode;

/*
There are a row of n houses, each house can be painted with one of the k colors.
The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example,
costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2,
and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Follow up:
Could you solve it in O(nk) runtime?
 */

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int j1 = 0;
            int j2 = 0;
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[i - 1][j] < min1) {
                    min2 = min1;
                    j2 = j1;
                    min1 = dp[i - 1][j];
                    j1 = j;
                } else {
                    if (dp[i - 1][j] < min2) {
                        min2 = dp[i - 1][j];
                        j2 = j;
                    }
                }
            }

            for (int j = 0; j < k; j++) {
                if (j == j1) {
                    dp[i][j] = dp[i - 1][j2] + costs[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j1] + costs[i][j];
                }
            }
        }
        int rst = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            rst = Math.min(rst, dp[n - 1][j]);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        PaintHouseII solu = new PaintHouseII();
        System.out.println(solu.minCostII(new int[][]{{1, 5, 3}, {2, 9, 4}}));
    }
}
