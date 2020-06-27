package LeetCode;


/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by
its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3),
which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class RangeSumQuery2DMutable {

    private int[][] arr;
    private int size;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        this.size = n;
        this.arr = new int[m][this.size * 2];
        build(matrix);
    }

    public void build(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = this.size, k = 0; k < this.size; j++, k++) {
                this.arr[i][j] = matrix[i][k];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = this.size - 1; j >= 0; j--) {
                this.arr[i][j] = this.arr[i][j * 2] + this.arr[i][j * 2 + 1];
            }
        }
    }

    void update(int row, int col, int val) {
        col += this.size;
        this.arr[row][col] = val;
        while (col > 0) {
            int l = col;
            int r = col;
            if (col % 2 == 0) {
                r++;
            } else {
                l--;
            }
            this.arr[row][col / 2] = this.arr[row][l] + this.arr[row][r];
            col /= 2;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rst = 0;
        int a = col1 + this.size;
        int b = col2 + this.size;
        for (int i = row1; i <= row2; i++) {
            col1 = a;
            col2 = b;
            int sum = 0;
            while (col1 <= col2) {
                if (col1 % 2 != 0) {
                    sum += this.arr[i][col1];
                    col1++;
                }
                if (col2 % 2 != 1) {
                    sum += this.arr[i][col2];
                    col2--;
                }
                col1 /= 2;
                col2 /= 2;
            }
            rst += sum;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        RangeSumQuery2DMutable solu = new RangeSumQuery2DMutable(
                new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(solu.sumRegion(2, 1, 4, 3));
        solu.update(3, 2, 2);
        System.out.println(solu.sumRegion(2, 1, 4, 3));
    }
}
