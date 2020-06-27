package LeetCode;

/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        // 由于存在负号，所以dp需要分别保存最大最小值
        int n = nums.length;
        int rst = nums[0];
        int predpma = nums[0];
        int predpmi = nums[0];
        int dpma = 0;
        int dpmi = 0;
        for (int i = 1; i < n; i++) {
            dpma = Math.max(nums[i], Math.max(predpma * nums[i], predpmi * nums[i]));
            dpmi = Math.min(nums[i], Math.min(predpma * nums[i], predpmi * nums[i]));
            rst = Math.max(rst, dpma);
            predpma = dpma;
            predpmi = dpmi;
        }
        return rst;
    }
}
