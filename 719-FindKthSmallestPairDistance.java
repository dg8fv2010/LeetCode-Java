package LeetCode;

/*
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    // 数组中两个数字之间有distance
    // 不同的distance组成一个数组，对这个数组进行二分查找
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mi) {
                    left++;
                }
                count += right - left;
            }
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FindKthSmallestPairDistance solu = new FindKthSmallestPairDistance();
        solu.smallestDistancePair(new int[]{1, 1, 3, 5, 8}, 5);
    }
}
