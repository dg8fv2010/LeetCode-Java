package LeetCode;

/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. 
The next state is created by applying the above rules simultaneously to every cell in the current state, 
where births and deaths occur simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

public class GameofLife {

    public void gameOfLife(int[][] board) {
        // 状态机转换：
        //状态0： 死细胞转为死细胞
        //状态1： 活细胞转为活细胞
        //状态2： 活细胞转为死细胞
        //状态3： 死细胞转为活细胞
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = count(board, i, j);
                if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }

    }

    public int count(int[][] board, int x, int y) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int cnt = 0;
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) {
                continue;
            }
            // 遇到1或者2的时候，表示原来是1
            if (board[newx][newy] == 1 || board[newx][newy] == 2) {
                cnt++;
            }
        }
        return cnt;
    }
}
