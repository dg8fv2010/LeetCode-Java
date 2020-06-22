package LeetCode;

import java.util.Arrays;

/*
Given an array of integers A sorted in non-decreasing order,
return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 */

public class SquaresofaSortedArray {

    // 双指针
    public int[] sortedSquares(int[] A) {
        int[] rst = new int[A.length];
        int idx = 0;
        while (idx < A.length) {
            if (A[idx] < 0) {
                idx++;
            } else {
                break;
            }
        }
        int i = idx - 1;
        int j = idx;
        idx = 0;
        while (i >= 0 && j < A.length) {
            if (A[i] * A[i] < A[j] * A[j]) {
                rst[idx] = A[i] * A[i];
                i--;
            } else {
                rst[idx] = A[j] * A[j];
                j++;
            }
            idx++;
        }
        while (i >= 0) {
            rst[idx] = A[i] * A[i];
            i--;
            idx++;
        }
        while (j < A.length) {
            rst[idx] = A[j] * A[j];
            j++;
            idx++;
        }
        return rst;
    }

    public int[] sortedSquares1(int[] A) {
        int[] rst = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            rst[i] = A[i] * A[i];
        }
        Arrays.sort(rst);
        return rst;

    }
}
