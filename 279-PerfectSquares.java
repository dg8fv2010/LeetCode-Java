package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {
    public int numSquares(int n) {
        int rst = 0;
        Queue<Integer> q = new LinkedList<>();
        int upper_bound = (int) Math.sqrt(n);

        q.add(0);
        while (!q.isEmpty()) {
            rst++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j = 1; j <= upper_bound; j++) {
                    int sum = cur + j * j;
                    if (sum == n) {
                        return rst;
                    }
                    if (sum < n) {
                        q.add(sum);
                    }
                }
            }
        }
        return -1;
    }

    // dp
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String[] a = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        PerfectSquares solu = new PerfectSquares();
        System.out.println("1:" + solu.numSquares(12));
    }
}
