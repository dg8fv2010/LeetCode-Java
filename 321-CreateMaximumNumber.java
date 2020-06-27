package LeetCode;

/*
Given two arrays of length m and n with digits 0-9 representing two numbers.
Create the maximum number of length k <= m + n from digits of the two.
The relative order of the digits from the same array must be preserved. Return an array of the k digits.

Note: You should try to optimize your time and space complexity.

Example 1:

Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]
Example 2:

Input:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:
[6, 7, 6, 0, 4]
Example 3:

Input:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
Output:
[9, 8, 9]
 */

import java.util.Stack;

public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // https://leetcode.com/problems/create-maximum-number/discuss/77285/Share-my-greedy-solution
        int m = nums1.length;
        int n = nums2.length;
        int[] rst = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] tmp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(tmp, 0, rst, 0)) {
                rst = tmp;
            }
        }
        return rst;
    }

    public boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }

    public int[] merge(int[] a, int[] b, int k) {
        int[] rst = new int[k];
        for (int i = 0, j = 0, idx = 0; idx < k; idx++) {
            rst[idx] = greater(a, i, b, j) ? a[i++] : b[j++];
        }

        return rst;
    }

    public int[] maxArray(int[] a, int len) {
        int[] rst = new int[len];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (st.size() + a.length - i > len && !st.isEmpty() && st.peek() < a[i]) {
                st.pop();
            }
            if (st.size() < len) {
                st.push(a[i]);
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            rst[i] = st.pop();
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CreateMaximumNumber solu = new CreateMaximumNumber();
        System.out.println(solu.maxNumber(new int[]{2, 5, 6, 4, 4, 0}, new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2}, 15));
        System.out.println(solu.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5));
    }
}
