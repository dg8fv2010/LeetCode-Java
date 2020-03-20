package LeetCode;

/*
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21


Example 2:

Input: 21
Output: -1
 */

import java.util.Arrays;

public class NextGreaterElementIII {
    // i从后往前遍历，找到a[i-1]<a[i]的位置
    // j从后往前遍历，找到a[j]>a[i-1]的位置
    // 交换a[i-1]和a[j]，对i之后的元素进行排序
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int idx1 = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                idx1 = i;
                break;
            }
        }
        idx1--;
        if (idx1 < 0) {
            return -1;
        }

        int idx2 = 0;
        for (int i = s.length() - 1; i >= idx1; i--) {
            if (s.charAt(i) > s.charAt(idx1)) {
                idx2 = i;
                break;
            }
        }

        StringBuilder tmp = new StringBuilder(s);
        char c = s.charAt(idx1);
        tmp.setCharAt(idx1, s.charAt(idx2));
        tmp.setCharAt(idx2, c);
        char[] arr = tmp.toString().toCharArray();
        Arrays.sort(arr, idx1 + 1, arr.length);
        long rst = Long.parseLong(new String(arr)); // 1999999999 会数据溢出，所以用long
        return rst > Integer.MAX_VALUE ? -1 : (int) rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        NextGreaterElementIII solu = new NextGreaterElementIII();
        System.out.println(solu.nextGreaterElement(1999999999));
        System.out.println(solu.nextGreaterElement(1685));
        System.out.println(solu.nextGreaterElement(54321));
    }
}
