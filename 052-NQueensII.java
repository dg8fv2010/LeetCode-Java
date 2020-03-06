package LeetCode;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */

import java.util.Arrays;

public class NQueensII {
    private int count = 0;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        helper(board, n, 0);
        return this.count;
    }

    public void helper(int[][] board, int n, int row) {
        for (int i = 0; i < n; i++) {
            if (is_not_under_attack(board, row, i)) {
                place_queue(board, row, i, 1); // 增加一个queue，更新棋盘
                if (row + 1 == n) {
                    this.count++;
                } else {
                    helper(board, n, row + 1);
                }
                place_queue(board, row, i, -1); // 删除一个queue，还原棋盘
            }
        }
    }

    public boolean is_not_under_attack(int[][] board, int row, int column) {
        return board[row][column] == 0;
    }

    public void place_queue(int[][] board, int row, int colum, int flag) {
        int i = row;
        int j = colum;
        while (i < board.length) {
            board[i++][j] += flag;
        }
        i = row;
        j = colum;
        while (i < board.length && j < board[0].length) {
            board[i++][j++] += flag;
        }
        i = row;
        j = colum;
        while (i < board.length && j >= 0) {
            board[i++][j--] += flag;
        }
    }

    public int totalNQueens1(int n) {
        int[] pos = new int[n];
        Arrays.fill(pos, 0, n - 1, -1);
        helper1(pos, 0);
        return this.count;
    }

    public void helper1(int[] pos, int row) {
        if (row == pos.length) this.count++;
        for (int i = 0; i < pos.length; i++) {
            if (is_valid(pos, row, i)) {
                pos[row] = i;
                helper1(pos, row + 1);
                pos[row] = -1;
            }
        }
    }

    public boolean is_valid(int[] pos, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == pos[i] || Math.abs(row - i) == Math.abs(col - pos[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        NQueensII solu = new NQueensII();
        System.out.println(solu.totalNQueens1(4));
    }

    public static void testcase2() {
        NQueensII solu = new NQueensII();
        System.out.println(solu.totalNQueens1(5));
    }

}
