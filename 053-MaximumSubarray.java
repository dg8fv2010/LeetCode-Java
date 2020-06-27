package LeetCode;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
which is more subtle.
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int rst = nums[0];
        for (int i = 1; i <= n; i++) {
            dp[i] = nums[i - 1] + Math.max(dp[i - 1], 0);
            //dp[i]=Math.max(dp[i-1]+nums[i-1], nums[i-1]);
            rst = Math.max(rst, dp[i]);
        }
        return rst;
    }

    public int maxSubArray1(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] a, int start, int end) {
        if (start == end) {
            return a[start];
        }
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        int mid = start + (end - start) / 2;
        int left_max = find(a, start, mid - 1);
        int right_max = find(a, mid + 1, end);
        int ml = 0;
        int mr = 0;
        for (int i = mid - 1, sum = 0; i >= start; i--) {
            sum += a[i];
            ml = Math.max(ml, sum);
        }

        for (int i = mid + 1, sum = 0; i <= end; i++) {
            sum += a[i];
            mr = Math.max(mr, sum);
        }
        return Math.max(Math.max(left_max, right_max), ml + mr + a[mid]);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MaximumSubarray solu = new MaximumSubarray();
        System.out.println(solu.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
