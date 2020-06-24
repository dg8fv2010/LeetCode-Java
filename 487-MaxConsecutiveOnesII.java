package LeetCode;

/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.


Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000


Follow up:
What if the input numbers come in one by one as an infinite stream?
In other words, you can't store all numbers coming from the stream as it's too large to hold in memory.
Could you solve it efficiently?
 */

public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int rst = 0;
        int l = 0;
        int r = 0;
        int zero_start = 0;
        boolean flag = false;
        while (r < nums.length) {
            if (nums[r] != 1) {
                if (!flag) {
                    flag = true;
                    zero_start = r;
                } else {
                    flag = false;
                    l = zero_start + 1;
                }
            }
            r++;
            rst = Math.max(rst, r - l);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        int[] a = new int[]{1, 1, 0, 1, 1, 1};
        int[] b = new int[]{0};
        int[] c = new int[]{1, 0, 1, 1, 0};

        MaxConsecutiveOnesII solu = new MaxConsecutiveOnesII();
        System.out.println("1:" + solu.findMaxConsecutiveOnes(a));
        System.out.println("1:" + solu.findMaxConsecutiveOnes(b));
        System.out.println("1:" + solu.findMaxConsecutiveOnes(c));
    }
}
