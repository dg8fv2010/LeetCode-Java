package LeetCode;

/*
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return i == s.length();
    }

    public boolean isSubsequence1(String s, String t) {
        int idx = 0;
        int idxt = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            boolean flag = false;
            for (int i = idxt; i < t.length(); i++) {
                if (c == t.charAt(i)) {
                    idxt = i + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            idx++;
        }
        return true;
    }
}
