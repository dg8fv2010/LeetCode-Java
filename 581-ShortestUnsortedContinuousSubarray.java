package LeetCode;

import java.util.Arrays;

/*
Given an integer array, you need to find one continuous subarray that
if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        // best
        int n = nums.length;
        int mx = nums[0];
        int mn = nums[n - 1];
        int start = -1;
        int end = -2;
        for (int i = 1; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            mn = Math.min(mn, nums[n - 1 - i]);
            if (mx > nums[i]) {
                end = i;
            }
            if (mn < nums[n - 1 - i]) {
                start = n - 1 - i;
            }
        }
        return end - start + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) {
                break;
            }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]) {
                break;
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != tmp[l] && nums[r] != tmp[r]) {
                break;
            }
            if (nums[l] == tmp[l]) {
                l++;
            }
            if (nums[r] == tmp[r]) {
                r--;
            }

        }

        if (r < l) {
            return 0;
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ShortestUnsortedContinuousSubarray solu = new ShortestUnsortedContinuousSubarray();
        System.out.println(solu.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
        System.out.println(solu.findUnsortedSubarray(new int[] { 1, 2, 3, 5, 4 }));
    }
}
