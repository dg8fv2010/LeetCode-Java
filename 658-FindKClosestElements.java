package LeetCode;

/*
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

 */

import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        // 从arr中找到k个元素，相当于从arr中删除n-k个元素
        List<Integer> rst = new LinkedList<>();
        for (int value : arr) {
            rst.add(value);
        }

        while (rst.size() > k) {
            if (x - rst.get(0) <= rst.get(rst.size() - 1) - x) {
                rst.remove(rst.size() - 1);
            } else {
                rst.remove(0);
            }
        }
        return rst;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> rst = new LinkedList<>();
        int l = 0;
        int r = arr.length - k - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (Math.abs(x - arr[mid]) <= Math.abs((arr[mid + k] - x))) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        for (int i = 0; i < k; i++) {
            rst.add(arr[l + i]);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
        testcase4();
        testcase5();
    }

    public static void testcase1() {
        FindKClosestElements solu = new FindKClosestElements();
        System.out.println(solu.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    public static void testcase2() {
        FindKClosestElements solu = new FindKClosestElements();
        System.out.println(solu.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    public static void testcase3() {
        FindKClosestElements solu = new FindKClosestElements();
        System.out.println(solu.findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4));
    }

    public static void testcase4() {
        FindKClosestElements solu = new FindKClosestElements();
        System.out.println(solu.findClosestElements(new int[]{1}, 1, 0));
    }

    public static void testcase5() {
        FindKClosestElements solu = new FindKClosestElements();
        System.out.println(solu.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }
}
