package LeetCode;

/*
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.



Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.






Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.



Example:

Input: m = 1, n = 1
Output: 9
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.
 */

public class AndroidUnlockPatterns {
    int rst;

    int numberOfPatterns(int m, int n) {
        this.rst = 0;
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean[][] visited = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visited[i][j] = true;
                search(m, n, grid, i, j, visited, 1);
                visited[i][j] = false;
            }
        }
        return this.rst;
    }

    public void search(int m, int n, int[][] grid, int x, int y, boolean[][] visited, int len) {
        if (len > n) {
            return;
        }
        if (len >= m && len <= n) {
            this.rst++;
        }
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            if (newx < 0 || newy < 0 || newx >= grid.length || newy >= grid[0].length) {
                continue;
            }
            if (visited[newx][newy]) {
                search(m, n, grid, newx, newy, visited, len);
            } else {
                visited[newx][newy] = true;
                search(m, n, grid, newx, newy, visited, len + 1);
                visited[newx][newy] = false;
            }
        }
    }
}
