package LeetCode;

/*
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:

There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.


Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).


Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 */

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    public static class TrieNode {
        TrieNode[] children;
        List<String> words;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.words = new ArrayList<>();
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> rst = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            create_tree(root, word);
        }

        for (String word : words) {
            List<String> tmp = new ArrayList<>();
            tmp.add(word);
            dfs(root, tmp, rst);
        }
        return rst;
    }

    public void create_tree(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.words.add(word);
        }
    }

    public void dfs(TrieNode root, List<String> tmp, List<List<String>> rst) {
        int size = tmp.size();
        if (size == tmp.get(0).length()) {
            rst.add(new ArrayList<>(tmp)); // 后面tmp会被回收，不能直接把tmp放进rst
            return;
        }

        String prefix = "";
        for (String str : tmp) {
            prefix += str.charAt(size);
        }
        List<String> words = get_words(root, prefix);
        for (String word : words) {
            tmp.add(word);
            dfs(root, tmp, rst);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<String> get_words(TrieNode root, String prefix) {
        List<String> rst = new ArrayList<>();
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) return rst;
            cur = cur.children[c - 'a'];
        }
        rst.addAll(cur.words);
        return rst;
    }


    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        WordSquares solu = new WordSquares();
        String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
        System.out.println(solu.wordSquares(words));
    }
}
