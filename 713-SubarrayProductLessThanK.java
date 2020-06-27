package LeetCode;

/*
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 */

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 滑动窗口
        int rst = 0;
        int start = 0;
        int multi = 1;
        for (int i = 0; i < nums.length; i++) {
            multi *= nums[i];
            while (start <= i && multi >= k) {
                multi /= nums[start];
                start++;
            }
            rst += i - start + 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SubarrayProductLessThanK solu = new SubarrayProductLessThanK();
        System.out.println(solu.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
