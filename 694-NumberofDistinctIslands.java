package LeetCode;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011
Given the above grid map, return 1.



Example 2:

11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:

11
1
and

 1
11
are considered different island shapes, because we do not consider reflection / rotation.



Note: The length of each dimension in the given grid does not exceed 50.
 */

import java.util.HashSet;

public class NumberofDistinctIslands {
    // 用字符串保存每个1相对于起点的位置
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        HashSet<String> rst = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    HashSet<String> set = new HashSet<>();
                    dfs(grid, visited, i, j, set, i, j);
                    String tmp = "";
                    for (String s : set) {
                        tmp += s + "-";
                    }
                    rst.add(tmp);
                }
            }
        }
        return rst.size();
    }

    public void dfs(int[][] grid, boolean[][] visited, int x, int y, HashSet<String> set, int startx, int starty) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newy < 0 || newx >= grid.length || newy >= grid[0].length || grid[newx][newy] == 0 || visited[newx][newy]) {
                continue;
            }
            set.add((newx - startx) + "_" + (newy - starty));
            visited[newx][newy] = true;
            dfs(grid, visited, newx, newy, set, startx, starty);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        int[][] grid = new int[][]{{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        NumberofDistinctIslands solu = new NumberofDistinctIslands();
        System.out.println(solu.numDistinctIslands(grid));
        int[][] grid1 = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(solu.numDistinctIslands(grid1));
    }
}
