package LeetCode;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */

import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new LinkedList<>();
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            list.add(sb.toString());
        }
        search(rst, list, 0, n);
        return rst;
    }

    public void search(List<List<String>> rst, List<String> list, int level, int n) {
        if (level == n) {
            rst.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(list, level, i)) {
                place(list, level, i, true);
                search(rst, list, level + 1, n);
                place(list, level, i, false);
            }
        }
    }

    public boolean check(List<String> list, int level, int i) {
        int x = level;
        int y = i;

        while (x >= 0) {
            if (list.get(x).charAt(i) == 'Q') {
                return false;
            }
            x--;
        }

        x = level;
        y = i;
        while (x >= 0 && y >= 0) {
            if (list.get(x).charAt(y) == 'Q') {
                return false;
            }
            x--;
            y--;
        }

        x = level;
        y = i;
        while (x >= 0 && y < list.get(0).length()) {
            if (list.get(x).charAt(y) == 'Q') {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    public void place(List<String> list, int level, int i, boolean flag) {
        StringBuilder sb = new StringBuilder(list.get(level));
        if (flag) {
            sb.setCharAt(i, 'Q');
        } else {
            sb.setCharAt(i, '.');
        }
        list.set(level, sb.toString());
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        NQueens solu = new NQueens();
        System.out.println(solu.solveNQueens(4));
    }
}
