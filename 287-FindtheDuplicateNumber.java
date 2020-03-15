package LeetCode;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class FindtheDuplicateNumber {
    // 快慢指针
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int p = nums[0];
        int q = slow;
        while (p != q) {
            p = nums[p];
            q = nums[q];
        }

        return p;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FindtheDuplicateNumber solu = new FindtheDuplicateNumber();
        System.out.println(solu.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(3 ^ 1);
    }

}
