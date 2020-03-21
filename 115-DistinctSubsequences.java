package LeetCode;

/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
 */

import java.util.HashMap;
import java.util.TreeSet;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int[][] dp = new int[tLen + 1][sLen + 1];
        for (int j = 0; j < sLen; j++) {
            dp[0][j] = 1;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 1; i < tLen + 1; i++) {
            for (int j = 1; j < sLen + 1; j++) {
                if (tArr[i - 1] == sArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLen][sLen];
    }

    int cnt = 0;

    // 超时
    public int numDistinct1(String s, String t) {
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            TreeSet<Integer> l = map.getOrDefault(s.charAt(i), null);
            if (l == null) {
                l = new TreeSet<>();
            }
            l.add(i);
            map.put(s.charAt(i), l);
        }
        check(t, 0, map, -1);
        return this.cnt;
    }

    public void check(String t, int idxt, HashMap<Character, TreeSet<Integer>> map, int prev) {
        if (idxt == t.length()) {
            this.cnt++;
            return;
        }

        char c = t.charAt(idxt);
        TreeSet<Integer> l = map.getOrDefault(c, null);
        if (l == null) {
            return;
        }

        Integer cur = l.higher(prev);
        while (cur != null) {
            check(t, idxt + 1, map, cur);
            cur = l.higher(cur);
        }

    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        DistinctSubsequences solu = new DistinctSubsequences();
        //System.out.println(solu.numDistinct("rabbbit", "rabbit"));
        System.out.println(solu.numDistinct("babgbag", "bag"));
    }

}
