package LeetCode;

/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 */

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = false;
                if (j > 0) {
                    if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
                if (i > 0) {
                    if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                        dp[i][j] |= dp[i - 1][j];
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
        InterleavingString solu = new InterleavingString();
        System.out.println(solu.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solu.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
