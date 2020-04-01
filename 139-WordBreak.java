package LeetCode;
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    // 需要用map保存已有结果才不会超时
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<>();
        return search(s, wordDict, map);
    }

    public boolean search(String s, List<String> dict, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.length() == 0) {
            return true;
        }
        for (String dic : dict) {
            if (s.startsWith(dic)) {
                if (search(s.substring(dic.length()), dict, map)) {
                    map.put(s.substring(dic.length()), true);
                    return true;
                } else {
                    map.put(s.substring(dic.length()), false);
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        WordBreak solu = new WordBreak();
        List<String> l = new LinkedList<>();
        l.add("cat");
        l.add("cats");
        l.add("and");
        l.add("sand");
        l.add("dog");
        System.out.println(solu.wordBreak("catsanddog", l));
    }

    public static void testcase2() {
        WordBreak solu = new WordBreak();
        List<String> l = new LinkedList<>();
        l.add("apple");
        l.add("pen");
        l.add("applepen");
        l.add("pine");
        l.add("pineapple");
        System.out.println(solu.wordBreak("pineapplepenapple", l));
    }
}
