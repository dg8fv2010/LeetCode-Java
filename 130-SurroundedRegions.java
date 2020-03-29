package LeetCode;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        boolean[][] status = new boolean[board.length][board[0].length];
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                helper(board, status, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                helper(board, status, board.length - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                helper(board, status, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                helper(board, status, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!status[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void helper(char[][] board, boolean[][] status, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 'X' || status[x][y]) {
            return;
        }

        status[x][y] = true;
        helper(board, status, x + 1, y);
        helper(board, status, x, y + 1);
        helper(board, status, x - 1, y);
        helper(board, status, x, y - 1);
    }
}
