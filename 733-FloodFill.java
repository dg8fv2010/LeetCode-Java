package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */

public class FloodFill {
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return null;
        int[][] rst = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                rst[i][j] = image[i][j];
            }
        }
        int origin = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] dirx = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};

        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true;
                rst[cur[0]][cur[1]] = newColor;

                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + dirx[j];
                    int newY = cur[1] + dirY[j];
                    if (newX < 0 || newX >= image.length || newY < 0 || newY >= image[0].length ||
                            visited[newX][newY] || image[newX][newY] != origin) {
                        continue;
                    }
                    q.add(new int[]{newX, newY});
                }
            }

        }
        return rst;
    }

    private void dfs(int[][] rst, int[][] image, boolean[][] visited, int x, int y, int newColor, int originColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || visited[x][y] || image[x][y] != originColor) {
            return;
        }
        rst[x][y] = newColor;
        visited[x][y] = true;
        dfs(rst, image, visited, x - 1, y, newColor, originColor);
        dfs(rst, image, visited, x + 1, y, newColor, originColor);
        dfs(rst, image, visited, x, y - 1, newColor, originColor);
        dfs(rst, image, visited, x, y + 1, newColor, originColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return null;
        int[][] rst = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                rst[i][j] = image[i][j];
            }
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        int originColor = image[sr][sc];
        dfs(rst, image, visited, sr, sc, newColor, originColor);

        return rst;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] b = new int[][]{{0, 0, 0}, {0, 0, 0}};
        FloodFill solu = new FloodFill();
        solu.floodFill(a, 1, 1, 2);
        //System.out.println("1:" + solu.decodeString("3[a]2[bc]"));
    }
}
