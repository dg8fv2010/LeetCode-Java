package LeetCode;

/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input:
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.


Example 2:

Input:
nums = [1, 2, 3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.


Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].
 */

/*
需要考虑各种边界情况
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int l=-1;
        int r = nums.length - 1;
        int pivot = 0;
        int sumL = 0;
        int sumR = 0;
        for (int i=pivot+1;i<=r;i++) {
            sumR += nums[i];
        }
        while (pivot <= r) {
            if (pivot == r) {
                sumR = 0;
                if (sumL == sumR) {
                    return pivot;
                } else {
                    return -1;
                }
            }
            if (sumL == sumR) {
                return pivot;
            } else {
                sumL += nums[pivot];
                pivot++;
                sumR -= nums[pivot];
            }
        }

        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int sumL = 0;
        int sumR = 0;
        for (int i=0;i<nums.length;i++) {
            sumR += nums[i];
        }
        for (int i=0;i<nums.length;i++) {
            if (sumL == sumR-nums[i]-sumL) {
                return i;
            } else {
                sumL += nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 7, 3, 6, 5, 6};
        int[] nums3 = {-1,-1,-1,-1,-1,0};
        int[] nums4 = {-1,-1,-1,0,1,1};
        int[] nums5 = {-1,-1,0,1,1,0};
        FindPivotIndex solu = new FindPivotIndex();
        int rst = solu.pivotIndex2(nums1);
        System.out.println("1:" + rst);
        rst = solu.pivotIndex2(nums2);
        System.out.println("2:" + rst);
        rst = solu.pivotIndex2(nums3);
        System.out.println("3:" + rst);
        rst = solu.pivotIndex2(nums4);
        System.out.println("4:" + rst);
        rst = solu.pivotIndex2(nums5);
        System.out.println("5:" + rst);
    }
}
