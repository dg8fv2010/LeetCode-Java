package LeetCode;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return new LinkedList<>();
        }
        set.remove(beginWord);
        set.remove(endWord);

        HashMap<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 1);
        HashMap<String, List<String>> parents = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);

        List<List<String>> rst = new LinkedList<>();
        boolean found = false;
        int step = 0;

        while (!que.isEmpty() && !found) {
            step++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String p = que.poll();
                for (int j = 0; j < p.length(); j++) {
                    StringBuilder sb = new StringBuilder(p);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String w = sb.toString();
                        if (w.equals(endWord)) {
                            found = true;
                            if (parents.getOrDefault(w, null) == null) {
                                parents.put(w, new LinkedList<>());
                            }
                            parents.get(w).add(p);
                        } else {
                            if (steps.containsKey(w) && step < steps.get(w)) {
                                if (parents.getOrDefault(w, null) == null) {
                                    parents.put(w, new LinkedList<>());
                                }
                                parents.get(w).add(p);
                            }
                        }

                        if (!set.contains(w)) {
                            continue;
                        }
                        set.remove(w);
                        que.add(w);
                        steps.put(w, steps.get(p) + 1);
                        if (parents.getOrDefault(w, null) == null) {
                            parents.put(w, new LinkedList<>());
                        }
                        parents.get(w).add(p);
                    }
                }
            }
        }

        if (found) {
            getParents(endWord, beginWord, parents, new LinkedList<>(Arrays.asList(endWord)), rst);
        }
        return rst;
    }

    public void getParents(String word, String begin, HashMap<String, List<String>> parents, List<String> cur, List<List<String>> rst) {
        if (word.equals(begin)) {
            List<String> tmp = new LinkedList<>(cur);
            Collections.reverse(tmp);
            rst.add(tmp);
            return;
        }

        List<String> p = parents.get(word);
        for (String s : p) {
            cur.add(s);
            getParents(s, begin, parents, cur, rst);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        WordLadderII solu = new WordLadderII();

        String[] s = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> l = new LinkedList<>(Arrays.asList(s));
        System.out.println(solu.findLadders("hit", "cog", l));
    }
}
