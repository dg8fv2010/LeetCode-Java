package LeetCode;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));
            if (cur > len) {
                len = cur;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + len);
    }

    public int getLen(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return r - l - 1;
    }
}
