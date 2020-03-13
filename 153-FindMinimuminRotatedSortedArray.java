package LeetCode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        FindMinimuminRotatedSortedArray solu = new FindMinimuminRotatedSortedArray();
        System.out.println(solu.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solu.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static void testcase2() {
        FindMinimuminRotatedSortedArray solu = new FindMinimuminRotatedSortedArray();
        System.out.println(solu.findMin(new int[]{1}));
    }
}
