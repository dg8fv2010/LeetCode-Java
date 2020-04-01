package LeetCode;

/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.



Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.


Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 */

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;

        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, k, avg, 0, 0);
    }

    public boolean dfs(int[] num, boolean[] visited, int k, int avg, int idx, int cursum) {
        if (k == 1) {
            return true;
        }
        if (cursum > avg) {
            return false;
        }
        if (cursum == avg) {
            return dfs(num, visited, k - 1, avg, 0, 0);
        }

        for (int i = idx; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (dfs(num, visited, k, avg, i + 1, cursum + num[i])) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        PartitiontoKEqualSumSubsets solu = new PartitiontoKEqualSumSubsets();
        System.out.println(solu.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
