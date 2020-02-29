package LeetCode;

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 */

import java.util.LinkedList;
import java.util.List;

public class WordSearchII {
    public static class TrieNode {
        private TrieNode[] children;
        private String str;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.str = "";
        }

        public void setStr(String s) {
            this.str = s;
        }

        public String getStr() {
            return this.str;
        }
    }

    // 先用words创建Trie树
    // 再遍历board
    // 不可以根据board创建树
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new LinkedList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            this.creat_tree(root, word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    this.search(root.children[board[i][j] - 'a'], board, visited, i, j, rst);
                }
            }
        }

        return rst;
    }

    public void creat_tree(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.setStr(word);
    }

    public void search(TrieNode root, char[][] board, boolean[][] visited, int i, int j, List<String> rst) {
        if (!root.getStr().isEmpty()) {
            rst.add(root.getStr());
            root.setStr("");
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[i][j] = true;
        for (int[] d : dir) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length &&
                    !visited[nx][ny] && root.children[board[nx][ny] - 'a'] != null) {
                search(root.children[board[nx][ny] - 'a'], board, visited, nx, ny, rst);
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        testcase2();
    }

    public static void testcase1() {
        WordSearchII solu = new WordSearchII();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(solu.findWords(board, words));
    }

    public static void testcase2() {
        WordSearchII solu = new WordSearchII();
        char[][] board = new char[][]{{'a', 'b'}};
        String[] words = new String[]{"ba"};
        System.out.println(solu.findWords(board, words));
    }
}
