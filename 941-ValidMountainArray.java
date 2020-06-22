package LeetCode;

/*
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]




Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true


Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
 */

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        int n = A.length;
        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }
        while (i + 1 < n && A[i] > A[i + 1]) {
            i++;
        }
        return i == n - 1;
    }

    public boolean validMountainArray1(int[] A) {
        int idx = 1;
        int n = A.length;
        if (n < 3) {
            return false;
        }
        while (idx < n) {
            if (A[idx] > A[idx - 1]) {
                idx++;
            } else {
                break;
            }
        }

        while (idx < n) {
            if (A[idx] < A[idx - 1]) {
                idx++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ValidMountainArray solu = new ValidMountainArray();
        System.out.println(solu.validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
