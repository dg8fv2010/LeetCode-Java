package LeetCode;

/*
Given a string s, find the longest palindromic subsequence's length in s.
You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 */

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (arr[i] == arr[i + 1]) ? 2 : 1;
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (arr[i] == arr[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }

        return dp[0][n - 1];
    }
}
