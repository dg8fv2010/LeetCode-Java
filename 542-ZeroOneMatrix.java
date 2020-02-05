package LeetCode;

/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]


Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) return null;
        int[][] rst = new int[matrix.length][matrix[0].length];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rst[i][j] = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) {
                    rst[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int new_x = cur[0] + dir[j][0];
                    int new_y = cur[1] + dir[j][1];
                    if (new_x >= 0 && new_x < matrix.length && new_y >= 0 && new_y < matrix[0].length) {
                        if (rst[new_x][new_y] > rst[cur[0]][cur[1]] + 1) {
                            rst[new_x][new_y] = rst[cur[0]][cur[1]] + 1;
                            q.add(new int[]{new_x, new_y});
                        }
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] b = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        ZeroOneMatrix solu = new ZeroOneMatrix();
        solu.updateMatrix(b);
        //System.out.println("1:" + solu.decodeString("3[a]2[bc]"));
    }
}
