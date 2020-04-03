package LeetCode;

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.


Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        Queue<String> que = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.add((i + "-" + j));
                }
            }
        }

        int rst = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            rst++;
            for (int i = 0; i < size; i++) {
                String[] pos = que.poll().split("-");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);

                int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];
                    if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length || grid[newx][newy] != 1) {
                        continue;
                    }
                    grid[newx][newy] = 2;
                    que.add(newx + "-" + newy);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(0, rst - 1);
    }
}
