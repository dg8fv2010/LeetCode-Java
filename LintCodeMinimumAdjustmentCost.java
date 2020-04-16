package LeetCode;

/*
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Example
Example 1:
	Input:  [1,4,2,3], target=1
	Output:  2

Example 2:
	Input:  [3,5,4,7], target=2
	Output:  1

Notice
You can assume each number in the array is a positive integer and not greater than 100.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LintCodeMinimumAdjustmentCost {

    public int MinAdjustmentCost(List<Integer> A, int target) {
        int n = A.size();
        int[][] dp = new int[n + 1][100 + 1];

        for (int i = 1; i <= 100; i++) {
            dp[1][i] = Math.abs(A.get(0) - i);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j - target; k <= j + target; k++) {
                    if (k < 1 || k > 100) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i - 1)));
                }
            }
        }

        int rst = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            rst = Math.min(rst, dp[n][i]);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeMinimumAdjustmentCost solu = new LintCodeMinimumAdjustmentCost();
        System.out.println(solu.MinAdjustmentCost(new LinkedList<>(Arrays.asList(1, 4, 2, 3)), 1));
        System.out.println(solu.MinAdjustmentCost(new LinkedList<>(Arrays.asList(3, 5, 4, 7)), 2));
    }
}
