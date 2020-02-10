package LeetCode;

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
 */

import java.util.*;

public class IntersectionofTwoArrays {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> rst = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                rst.add(num);
            }
        }

        return rst.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1)  set1.add(num);
        for (int num : nums2) set2.add(num);

        set1.retainAll(set2);

        return set1.stream().mapToInt(i -> i).toArray();
    }

    public static void testcase1() {
        int[] a = new int[]{4, 9, 5};
        int[] b = new int[]{9, 4, 9, 8, 4};
        IntersectionofTwoArrays solu = new IntersectionofTwoArrays();
        int[] c = solu.intersection(a, b);
    }

    public static void main(String[] args) {
        testcase1();
    }
}
