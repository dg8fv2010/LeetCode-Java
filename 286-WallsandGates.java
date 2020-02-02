package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */

public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int[] dirX = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + dirX[j];
                    int newY = cur[1] + dirY[j];
                    if (newX < 0 || newX >= rooms.length || newY < 0 || newY >= rooms.length) {
                        continue;
                    }
                    rooms[newX][newY] = Math.min(rooms[newX][newY], step + 1);
                    q.add(new int[]{newX, newY});
                }
            }
        }

    }
}
