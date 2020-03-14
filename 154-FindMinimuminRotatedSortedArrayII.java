package LeetCode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 */

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // 出现3，3，1，3这种情况时，两头的3会使得二分失效
        // 此时需要将r减1，除去相同的元素
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return nums[r];
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FindMinimuminRotatedSortedArrayII solu = new FindMinimuminRotatedSortedArrayII();
        System.out.println(solu.findMin(new int[]{1, 3, 5}));
        System.out.println(solu.findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(solu.findMin(new int[]{3, 3, 1, 3}));

    }
}
