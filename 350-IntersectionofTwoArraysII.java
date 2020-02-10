package LeetCode;

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IntersectionofTwoArraysII {
    // map中的list保存num1中每个元素的位置
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.get(nums1[i]).add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums1[i], list);
            }
        }

        LinkedList<Integer> rst = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.get(nums2[i]).poll();
                if (map.get(nums2[i]).size() == 0) {
                    map.remove(nums2[i]);
                }
                rst.add(nums2[i]);
            }
        }

        int[] a = new int[rst.size()];
        for (int i = 0; i < rst.size(); i++) {
            a[i] = rst.get(i);
        }
        return a;
    }

    // map中第二个int表示元素出现的数量
    // num2中出现相同的就减1，直至减为0
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.replace(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.replace(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) <= 0) {
                    map.remove(nums2[i]);
                }
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static void testcase1() {
        int[] a = new int[]{1, 2, 1, 2};
        int[] b = new int[]{2, 2};
        IntersectionofTwoArraysII solu = new IntersectionofTwoArraysII();
        solu.intersect(a, b);
    }

    public static void main(String[] args) {
        testcase1();
    }
}
