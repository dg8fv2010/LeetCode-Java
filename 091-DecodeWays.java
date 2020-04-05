package LeetCode;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length() + 1]; // 前n个字符有多少种解密方式
        dp[0] = 1; // 空字符串有1中解密方式
        for (int i = 1; i <= s.length(); i++) {
            if (arr[i - 1] != '0') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 0;
            }
            if (i > 1) {
                int tmp = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
                if (tmp >= 10 && tmp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        DecodeWays solu = new DecodeWays();
        System.out.println(solu.numDecodings("226"));
    }
}
