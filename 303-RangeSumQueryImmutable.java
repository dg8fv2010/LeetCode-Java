package LeetCode;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */

public class RangeSumQueryImmutable {
    
    private int[] arr;

    public RangeSumQueryImmutable(int[] nums) {
        this.arr = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            this.arr[i] = sum;
        }

    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return this.arr[j];
        }
        return this.arr[j] - this.arr[i - 1];
    }
}
