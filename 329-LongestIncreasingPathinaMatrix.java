package LeetCode;

/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */

public class LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rst = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rst = Math.max(rst, search(matrix, dp, i, j));
            }
        }
        return rst;
    }

    public int search(int[][] matrix, int[][] dp, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newy < 0 || newx >= matrix.length || newy >= matrix[0].length || matrix[newx][newy] <= matrix[x][y]) {
                continue;
            }
            dp[x][y] = Math.max(dp[x][y], 1 + search(matrix, dp, newx, newy));
        }
        return dp[x][y];
    }
}
