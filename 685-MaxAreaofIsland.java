package LeetCode;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 */


public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rst = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rst = Math.max(rst, helper(grid, visited, i, j, 0));
                }
            }
        }
        return rst;
    }

    public int helper(int[][] grid, boolean[][] visited, int x, int y, int cnt) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || visited[x][y]) {
            return cnt;
        }
        visited[x][y] = true;
        cnt++;
        cnt = helper(grid, visited, x + 1, y, cnt);
        cnt = helper(grid, visited, x, y + 1, cnt);
        cnt = helper(grid, visited, x - 1, y, cnt);
        cnt = helper(grid, visited, x, y - 1, cnt);

        return cnt;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        int[][] a = new int[][]{{1, 1}, {1, 0}};
        int[][] b = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        MaxAreaofIsland solu = new MaxAreaofIsland();
        System.out.println(solu.maxAreaOfIsland(a));
        System.out.println(solu.maxAreaOfIsland(b));
    }
}
