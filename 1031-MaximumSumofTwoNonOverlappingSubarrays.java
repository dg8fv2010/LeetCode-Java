package LeetCode;

/*
Given an array A of non-negative integers, return the maximum sum of elements
in two non-overlapping (contiguous) subarrays, which have lengths L and M.
(For clarification, the L-length subarray could occur before or after the M-length subarray.)

Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:

0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
0 <= j < j + M - 1 < i < i + L - 1 < A.length.


Example 1:

Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.


Note:

L >= 1
M >= 1
L + M <= A.length <= 1000
0 <= A[i] <= 1000
 */

public class MaximumSumofTwoNonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        // 记A[i]为A[0:i+1]的和；
        //  记Lmax为除末尾M个元素外的最大L长度子序列的和；
        //  记Mmax为除末尾N个元素外的最大M长度子序列的和；
        //  记res为当前L子序列、M子序列和的最大值；
        //  遍历A[L+M:A.length], 求res, ( Lmax+末尾M个元素 ), ( Mmax+末尾L个元素 ) 中的最大值。
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        int maxL = A[L - 1];
        int maxM = A[M - 1];
        int rst = A[L + M - 1];
        for (int i = L + M; i < A.length; i++) {
            maxL = Math.max(maxL, A[i - M] - A[i - M - L]);
            maxM = Math.max(maxM, A[i - L] - A[i - M - L]);
            rst = Math.max(rst, Math.max(maxL + A[i] - A[i - M], maxM + A[i] - A[i - L]));
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MaximumSumofTwoNonOverlappingSubarrays solu = new MaximumSumofTwoNonOverlappingSubarrays();
        //System.out.println(solu.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
        //System.out.println(solu.maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        System.out.println(solu.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
        System.out.println(solu.maxSumTwoNoOverlap(new int[]{1, 0, 1}, 1, 1));
    }
}
