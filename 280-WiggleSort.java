package LeetCode;


/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
 */

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        // 当i为奇数时，nums[i] >= nums[i - 1]
        // 当i为偶数时，nums[i] <= nums[i - 1]
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
