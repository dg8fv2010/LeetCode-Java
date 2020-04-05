package LeetCode;

/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] rst = new int[m][n];

        // up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        dp[i][j] = 1;
                    }
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
                rst[i][j] += dp[i][j];
            }
        }

        // down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        dp[i][j] = 1;
                    }
                    if (i < m - 1) {
                        dp[i][j] += dp[i + 1][j];
                    }
                }
                rst[i][j] += dp[i][j];
            }
        }

        // left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        dp[i][j] = 1;
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
                rst[i][j] += dp[i][j];
            }
        }

        // right
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 0;
                    if (grid[i][j] == 'E') {
                        dp[i][j] = 1;
                    }
                    if (j < n - 1) {
                        dp[i][j] += dp[i][j + 1];
                    }
                }
                rst[i][j] += dp[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    result = Math.max(result, rst[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        BombEnemy solu = new BombEnemy();
        char[][] grid = new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}};
        System.out.println(solu.maxKilledEnemies(grid));
    }
}
