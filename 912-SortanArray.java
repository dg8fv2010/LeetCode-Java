package LeetCode;

/*
Given an array of integers nums, sort the array in ascending order.



Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]


Constraints:

1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortanArray {
    public List<Integer> sortArray(int[] nums) {
        int[] rst = mergesort(nums);
        List<Integer> l = new LinkedList<>();
        for (int value : rst) {
            l.add(value);
        }
        return l;
    }

    public int[] mergesort(int[] nums) {
        if (nums.length <= 1) return nums;
        int l = 0;
        int r = nums.length;
        int mid = l + (r - l) / 2;
        int[] left = mergesort(Arrays.copyOfRange(nums, l, mid));
        int[] right = mergesort(Arrays.copyOfRange(nums, mid, r));
        return merge_helper(left, right);
    }

    public int[] merge_helper(int[] left, int[] right) {
        int[] rst = new int[left.length + right.length];
        int idx = 0;
        int idxl = 0;
        int idxr = 0;
        while (idxl < left.length && idxr < right.length) {
            if (left[idxl] < right[idxr]) {
                rst[idx++] = left[idxl++];
            } else {
                rst[idx++] = right[idxr++];
            }
        }

        while (idxl < left.length) {
            rst[idx++] = left[idxl++];
        }
        while (idxr < right.length) {
            rst[idx++] = right[idxr++];
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SortanArray solu = new SortanArray();
        System.out.println(solu.sortArray(new int[]{5, 2, 3, 1}));
    }
}
