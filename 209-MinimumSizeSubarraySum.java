package LeetCode;

/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int rst = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int j = i;
            while (sum < s && j < nums.length - 1) {
                j++;
                sum += nums[j];
            }
            if (sum >= s) {
                rst = Math.min(rst, j - i + 1);
            }
        }
        if (rst > nums.length) {
            return 0;
        }
        return rst;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int rst = nums.length + 1;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                rst = Math.min(rst, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if (rst > nums.length) {
            return 0;
        }
        return rst;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int rst = nums.length + 1;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
            if (prefixSum[i] >= s) {
                int left = 0;
                int right = i;
                while (left + 1 < right) {
                    int mid = left + (right - left) / 2;
                    if (prefixSum[i] - prefixSum[mid] >= s) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }

                if (prefixSum[i] - prefixSum[right] >= s) {
                    rst = Math.min(rst, i - right);
                } else {
                    rst = Math.min(rst, i - left);
                }
            }
        }

        if (rst > nums.length) {
            return 0;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 2, 4, 3};
        int[] b = new int[]{1, 4, 4};

        MinimumSizeSubarraySum solu = new MinimumSizeSubarraySum();
        //System.out.println("1:" + solu.minSubArrayLen2(4, b));
        System.out.println("1:" + solu.minSubArrayLen2(7, a));
    }
}
