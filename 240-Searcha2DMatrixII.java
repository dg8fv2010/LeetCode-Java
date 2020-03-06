package LeetCode;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */

public class Searcha2DMatrixII {
    // 从左下角开始，x减小数变小，y增大数增大
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int x = matrix.length - 1;
        int y = 0;
        while (true) {
            if (matrix[x][y] > target) x--;
            else if (matrix[x][y] < target) y++;
            else return true;

            if (x < 0 || y >= matrix[0].length) break;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public boolean helper(int[][] matrix, int target, int left_top_x, int left_top_y, int right_bottom_x, int right_bottom_y) {
        if (left_top_x > right_bottom_x || left_top_y > right_bottom_y) return false;
        int x = left_top_x + (right_bottom_x - left_top_x) / 2;
        int y = left_top_y + (right_bottom_y - left_top_y) / 2;
        if (matrix[x][y] == target) return true;

        if (matrix[x][y] > target) {
            return helper(matrix, target, left_top_x, left_top_y, x - 1, right_bottom_y) ||
                    helper(matrix, target, x, left_top_y, right_bottom_x, y - 1);
        } else {
            return helper(matrix, target, x + 1, left_top_y, right_bottom_x, right_bottom_y) ||
                    helper(matrix, target, left_top_x, y + 1, x, right_bottom_y);
        }
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        int[][] m = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        Searcha2DMatrixII solu = new Searcha2DMatrixII();
        System.out.println(solu.searchMatrix(m, 5));
    }

    public static void testcase2() {
        int[][] m = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        Searcha2DMatrixII solu = new Searcha2DMatrixII();
        System.out.println(solu.searchMatrix(m, 20));
    }
}
