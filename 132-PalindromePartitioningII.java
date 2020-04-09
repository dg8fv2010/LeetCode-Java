package LeetCode;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

import java.util.Arrays;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isPalin[i], false);
        }

        for (int t = 0; t < n; t++) {
            int l = t;
            int r = t;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                isPalin[l][r] = true;
                l--;
                r++;
            }

            l = t;
            r = t + 1;
            while (l >= 0 && r < n && arr[l] == arr[r]) {
                isPalin[l][r] = true;
                l--;
                r++;
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] - 1;
    }

    public int minCut1(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome(arr, j, i - 1)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()] - 1;
    }

    public boolean isPalindrome(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        PalindromePartitioningII solu = new PalindromePartitioningII();
        System.out.println(solu.minCut("aab"));
    }
}
