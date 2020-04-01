package LeetCode;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII {
    // 需要用map保存已有结果才不会超时
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return wordBreakHelper(s, wordDict, map);
    }

    public List<String> wordBreakHelper(String s, List<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> rst = new LinkedList<>();
        if (s.length() == 0) {
            rst.add("");
            return rst;
        }

        for (String dic : dict) {
            if (s.startsWith(dic)) {
                List<String> l = wordBreakHelper(s.substring(dic.length()), dict, map);
                for (String str : l) {
                    rst.add(dic + (str.length() == 0 ? "" : " ") + str);
                }
            }
        }
        map.put(s, rst);
        return rst;
    }

    public class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = "";
        }
    }

    // 字典树超时
    public List<String> wordBreak2(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String str : wordDict) {
            create_tree(root, str);
        }
        List<String> rst = new LinkedList<>();
        helper(rst, root, "", s);
        return rst;
    }

    public void create_tree(TrieNode root, String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = s;
    }

    public List<String> search_tree(TrieNode root, String s) {
        List<String> list = new LinkedList<>();
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
                if (cur.word.length() > 0) {
                    list.add(cur.word);
                }
            } else {
                break;
            }
        }
        return list;
    }

    public void helper(List<String> rst, TrieNode root, String cur_s, String s) {
        if (s.length() == 0) {
            rst.add(cur_s.substring(1));
            return;
        }
        List<String> list = search_tree(root, s);
        for (String l : list) {
            helper(rst, root, cur_s + " " + l, s.substring(l.length()));
        }
    }

    // 遍历dict里面的字符串去匹配s
    // 会超时
    public List<String> wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> rst = new LinkedList<>();
        search(rst, "", set, s);
        return rst;
    }

    public void search(List<String> rst, String cur, HashSet<String> set, String s) {
        if (s.length() == 0) {
            rst.add(cur.substring(1));
            return;
        }

        for (String str : set) {
            if (s.startsWith(str)) {
                search(rst, cur + " " + str, set, s.substring(str.length()));
            }
        }
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        WordBreakII solu = new WordBreakII();
        List<String> l = new LinkedList<>();
        l.add("cat");
        l.add("cats");
        l.add("and");
        l.add("sand");
        l.add("dog");
        System.out.println(solu.wordBreak("catsanddog", l));
    }

    public static void testcase2() {
        WordBreakII solu = new WordBreakII();
        List<String> l = new LinkedList<>();
        l.add("apple");
        l.add("pen");
        l.add("applepen");
        l.add("pine");
        l.add("pineapple");
        System.out.println(solu.wordBreak("pineapplepenapple", l));
    }
}
