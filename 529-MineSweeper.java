package LeetCode;

/*
Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.


Example 1:

Input:

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:

Input:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:



Note:

The range of the input matrix's height and width is [1,50].
The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
The input board won't be a stage when game is over (some mines have been revealed).
For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 */

public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        update_click(board, visited, click[0], click[1]);
        return board;
    }

    public void update_click(char[][] board, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        if (board[x][y] == 'E') {
            board[x][y] = 'B';
        }
        int cnt = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newy < 0 || newx >= board.length || newy >= board[0].length) {
                continue;
            }
            if (board[newx][newy] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
            return;
        }

        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newy < 0 || newx >= board.length || newy >= board[0].length) {
                continue;
            }
            update_click(board, visited, newx, newy);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        char[][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        MineSweeper solu = new MineSweeper();
        solu.updateBoard(board, new int[]{3, 0});
    }
}
