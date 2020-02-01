package LeetCode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rst = 0;
        Queue<String> island = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited.contains(i + "," + j) && grid[i][j] == '1') {
                    island.add(i + "," + j);
                    visited.add(i + "," + j);
                    rst++;
                    while (!island.isEmpty()) {
                        String cur = island.poll();
                        String[] tmp = cur.split(",");
                        int x = Integer.parseInt(tmp[0]);
                        int y = Integer.parseInt(tmp[1]);
                        for (int k = 0; k < 4; k++) {
                            int new_x = x + dirX[k];
                            int new_y = y + dirY[k];
                            String pos = new_x + "," + new_y;
                            if (new_x < 0 || new_x >= grid.length ||
                                    new_y < 0 || new_y >= grid[0].length ||
                                    visited.contains(pos) || grid[new_x][new_y] == '0') {
                                continue;
                            }
                            island.add(pos);
                            visited.add(pos);
                        }
                    }
                }
            }
        }

        return rst;
    }


    public static void main(String[] args) {
        char[][] a = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] b = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] c = new char[][]{{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        NumberofIslands solu = new NumberofIslands();
        System.out.println("1:" + solu.numIslands(b));
    }
}
