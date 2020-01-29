package LeetCode;

import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        int[][] arr0 = {{1}};
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        SpiralMatrix solu = new SpiralMatrix();
        System.out.println("1:" + solu.spiralOrder(arr2));
    }
}
