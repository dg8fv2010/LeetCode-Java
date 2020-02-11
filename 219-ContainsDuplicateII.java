package LeetCode;

/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int idx = map.get(nums[i]);
                if (i - idx <= k) {
                    return true;
                } else {
                    map.replace(nums[i], i);
                }
            }
        }

        return false;
    }

    public static void testcase1() {
        int[] a = new int[]{1, 2, 3, 1};
        ContainsDuplicateII solu = new ContainsDuplicateII();
        System.out.println(solu.containsNearbyDuplicate(a, 3));
    }

    public static void testcase2() {
        int[] a = new int[]{1, 0, 1, 1};
        ContainsDuplicateII solu = new ContainsDuplicateII();
        System.out.println(solu.containsNearbyDuplicate(a, 1));
    }

    public static void testcase3() {
        int[] a = new int[]{1, 2, 3, 1, 2, 3};
        ContainsDuplicateII solu = new ContainsDuplicateII();
        System.out.println(solu.containsNearbyDuplicate(a, 2));
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
    }

}
