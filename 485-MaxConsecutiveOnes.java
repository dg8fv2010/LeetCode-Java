package LeetCode;

/*
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int rst = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                len++;
            } else {
                len = 0;
            }

            rst = Math.max(rst, len);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 1, 1, 1};
        int[] b = new int[]{0};

        MaxConsecutiveOnes solu = new MaxConsecutiveOnes();
        System.out.println("1:" + solu.findMaxConsecutiveOnes(b));
    }
}
