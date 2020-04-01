package LeetCode;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (search(board, i, j, visited, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int x, int y, boolean[][] visited, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        if (visited[x][y] || board[x][y] != word.charAt(idx)) {
            return false;
        }
        visited[x][y] = true;
        if (search(board, x + 1, y, visited, word, idx + 1) ||
                search(board, x - 1, y, visited, word, idx + 1) ||
                search(board, x, y + 1, visited, word, idx + 1) ||
                search(board, x, y - 1, visited, word, idx + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }
}
