package LeetCode;


/*
This question is about implementing a basic elimination algorithm for Candy Crush.

Given a 2D integer array board representing the grid of candy,
different positive integers board[i][j] represent different types of candies.
A value of board[i][j] = 0 represents that the cell at position (i, j) is empty.
The given board represents the state of the game following the player's move.
Now, you need to restore the board to a stable state by crushing candies according to the following rules:

If three or more candies of the same type are adjacent vertically or horizontally,
"crush" them all at the same time - these positions become empty.
After crushing all candies simultaneously, if an empty space on the board has candies on top of itself,
then these candies will drop until they hit a candy or bottom at the same time.
(No new candies will drop outside the top boundary.)
After the above steps, there may exist more candies that can be crushed.
If so, you need to repeat the above steps.
If there does not exist more candies that can be crushed (ie. the board is stable),
then return the current board.
You need to perform the above rules until the board becomes stable, then return the current board.

Example 1:

Input:
board =
[[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
Output:
[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
Explanation:




Note:

The length of board will be in the range [3, 50].
The length of board[i] will be in the range [3, 50].
Each board[i][j] will initially start as an integer in the range [1, 2000].
 */

import java.util.LinkedList;
import java.util.List;

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        while (eliminate(board)) {
            drop(board);
        }
        return board;
    }

    public boolean eliminate(int[][] board) {
        List<int[]> del = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int x1 = i;
                int x2 = i;
                int y1 = j;
                int y2 = j;
                while (x1 >= 0 && i - x1 < 3 && board[x1][j] == board[i][j]) {
                    x1--;
                }
                while (x2 < board.length && x2 - i < 3 && board[x2][j] == board[i][j]) {
                    x2++;
                }
                while (y1 >= 0 && j - y1 < 3 && board[i][y1] == board[i][j]) {
                    y1--;
                }
                while (y2 < board[0].length && y2 - j < 3 && board[i][y2] == board[i][j]) {
                    y2++;
                }
                if (x2 - x1 > 3 || y2 - y1 > 3) {
                    del.add(new int[]{i, j});
                }
            }
        }

        for (int[] d : del) {
            int x = d[0];
            int y = d[1];
            board[x][y] = 0;
        }
        return !del.isEmpty();
    }

    public void drop(int[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            int idx = board.length - 1;
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    int tmp = board[i][j];
                    board[i][j] = board[idx][j];
                    board[idx][j] = tmp;
                    idx--;
                }
            }
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CandyCrush solu = new CandyCrush();
        System.out.println(solu.candyCrush(new int[][]{
                {110, 5, 112, 113, 114},
                {210, 211, 5, 213, 214},
                {310, 311, 3, 313, 314},
                {410, 411, 412, 5, 414},
                {5, 1, 512, 3, 3},
                {610, 4, 1, 613, 614},
                {710, 1, 2, 713, 714},
                {810, 1, 2, 1, 1},
                {1, 1, 2, 2, 2},
                {4, 1, 4, 4, 1014}}
        ));
    }
}
