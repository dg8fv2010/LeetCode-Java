package LeetCode;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.*;

public class WordLadder {
    class TreeNode {
        String val;
        List<String> neighbors;

        public TreeNode() {
            this.val = "";
            this.neighbors = new LinkedList<>();
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        while (!que.isEmpty()) {
            String word = que.poll();
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String newword = sb.toString();
                    if (!set.contains(newword)) {
                        continue;
                    }

                    if (newword.equals(endWord)) {
                        return map.get(word) + 1;
                    }
                    if (!map.containsKey(newword)) {
                        map.put(newword, map.get(word) + 1);
                        que.add(newword);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        WordLadder solu = new WordLadder();

        String[] s = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> l = new LinkedList<>(Arrays.asList(s));
        System.out.println(solu.ladderLength("hit", "cog", l));
    }
}
