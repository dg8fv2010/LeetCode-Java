package LeetCode;

/*
In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:

The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.


Example 1:

Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”


Example 2:

Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */

public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int[] cnt0 = new int[strs.length];
        int[] cnt1 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    cnt0[i]++;
                } else {
                    cnt1[i]++;
                }
            }
        }

        for (int i = 0; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                        continue;
                    }

                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= cnt0[i - 1] && k >= cnt1[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - cnt0[i - 1]][k - cnt1[i - 1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        OnesandZeroes solu = new OnesandZeroes();
        System.out.println(solu.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(solu.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
