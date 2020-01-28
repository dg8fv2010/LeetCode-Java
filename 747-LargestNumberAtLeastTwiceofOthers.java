package LeetCode;

/*
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int nMax = 0;
        for (int i=1;i<nums.length;i++) {
            if (nums[nMax] < nums[i]) {
                nMax = i;
            }
        }

        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=nums[nMax] && nums[i]*2>nums[nMax]) {
                return -1;
            }
        }

        return nMax;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 6, 1, 0};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 0};
        int[] nums4 = {0, 0, 3, 2};
        LargestNumberAtLeastTwiceofOthers solu = new LargestNumberAtLeastTwiceofOthers();
        System.out.println("1:"+solu.dominantIndex(nums1));
        System.out.println("2:"+solu.dominantIndex(nums2));
        System.out.println("3:"+solu.dominantIndex(nums3));
    }
}
