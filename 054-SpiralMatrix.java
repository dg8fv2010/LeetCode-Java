package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        List<Integer> rst = new LinkedList<>();
        int M = matrix.length;
        int N = matrix[0].length;
        int cur_r = 0;
        int cur_c = 0;
        boolean[][] tag = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tag[i][j] = false;
            }
        }
        int dir = 1;

        while (true) {
            int new_c = cur_c;
            int new_r = cur_r;
            rst.add(matrix[cur_r][cur_c]);
            tag[cur_r][cur_c] = true;

            if (dir == 1) {
                new_c = cur_c + 1;
                if (new_c == N || tag[new_r][new_c]) {
                    dir = 2;
                    new_r++;
                    new_c = cur_c;
                }
            } else if (dir == 2) {
                new_r = cur_r + 1;
                if (new_r == M || tag[new_r][new_c]) {
                    dir = 3;
                    new_c--;
                    new_r = cur_r;
                }
            } else if (dir == 3) {
                new_c = cur_c - 1;
                if (new_c < 0 || tag[new_r][new_c]) {
                    dir = 4;
                    new_r--;
                    new_c = cur_c;
                }
            } else if (dir == 4) {
                new_r = cur_r - 1;
                if (new_r < 0 || tag[new_r][new_c]) {
                    dir = 1;
                    new_r = cur_r;
                    new_c = cur_c + 1;
                }
            }

            if (new_c < 0 || new_c >= N || new_r < 0 || new_r >= M) {
                break;
            }
            if (tag[new_r][new_c]) {
                break;
            }
            cur_c = new_c;
            cur_r = new_r;

        }
        return rst;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return rst;
        }

        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                rst.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                rst.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    rst.add(matrix[r2][i]);
                }
                for (int i = r2 - 1; i > r1; i--) {
                    rst.add(matrix[i][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }

        return rst;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return rst;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        int[] dir_r = {0, 1, 0, -1};
        int[] dir_c = {1, 0, -1, 0};
        int dir = 0;
        boolean[][] seen = new boolean[M][N];
        int cur_r = 0;
        int cur_c = 0;

        for (int i = 0; i < M * N; i++) {
            rst.add(matrix[cur_r][cur_c]);
            int new_r = cur_r + dir_r[dir];
            int new_c = cur_c + dir_c[dir];
            seen[cur_r][cur_c] = true;

            if (new_r >= 0 && new_r < M && new_c >= 0 && new_c < N && !seen[new_r][new_c]) {
                cur_r = new_r;
                cur_c = new_c;
            } else {
                dir = (dir + 1) % 4;
                cur_r += dir_r[dir];
                cur_c += dir_c[dir];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] arr0 = {{1}};
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        LeetCode.SpiralMatrix solu = new LeetCode.SpiralMatrix();
        System.out.println("1:" + solu.spiralOrder2(arr2));
    }
}
