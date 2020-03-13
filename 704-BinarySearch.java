package LeetCode;

/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 */

public class BinarySearch {
    public int search1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public int helper(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;

        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return helper(nums, l, mid - 1, target);
        else return helper(nums, mid + 1, r, target);
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        BinarySearch solu = new BinarySearch();
        System.out.println(solu.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static void testcase2() {
        BinarySearch solu = new BinarySearch();
        System.out.println(solu.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
