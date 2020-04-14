package LeetCode;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                // 空的正则表达式不能和字符串匹配
                // 空的字符串可以和正则表达式匹配
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = false;
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                } else {
                    if (j > 1) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if (i > 0 && j > 1) {
                        if (p.charAt(j - 2) == '.' || (p.charAt(j - 2) == s.charAt(i - 1))) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        RegularExpressionMatching solu = new RegularExpressionMatching();
        System.out.println(solu.isMatch("aa", "a"));
        System.out.println(solu.isMatch("aa", "a*"));
        System.out.println(solu.isMatch("ab", ".*"));
        System.out.println(solu.isMatch("aab", "c*a*b"));
        System.out.println(solu.isMatch("mississippi", "mis*is*p*."));
    }
}
