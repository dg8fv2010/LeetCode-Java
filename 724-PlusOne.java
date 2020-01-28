package LeetCode;

/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] rst = new int[digits.length+1];
        rst[digits.length] = 1;
        for (int i=digits.length-1;i>=0;i--) {
            rst[i+1] = rst[i+1] + digits[i];
            if (rst[i+1] >= 10) {
                rst[i+1] -= 10;
                rst[i] = 1;
            }
        }
        if (rst[0] == 0) {
            int[] r = new int[digits.length];
            for (int i=0;i<rst.length-1;i++) {
                r[i] = rst[i+1];
            }
            return r;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,3,2,1};
        int[] nums3 = {1, 0};
        PlusOne solu = new PlusOne();
        System.out.println("1:"+solu.plusOne(nums1));
        System.out.println("2:"+solu.plusOne(nums2));
        System.out.println("3:"+solu.plusOne(nums3));
    }
}
