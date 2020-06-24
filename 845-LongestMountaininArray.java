package LeetCode;

/*
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
 */

public class LongestMountaininArray {
    public int longestMountain(int[] A) {
        int rst = 0;
        int idx = 1;
        int n = A.length;
        while (idx < n) {
            if (A[idx] <= A[idx - 1]) {
                idx++;
                continue;
            }

            int inc = 0;
            while (idx < n && A[idx] > A[idx - 1]) {
                idx++;
                inc++;
            }
            int des = 0;
            while (inc > 0 && idx < n && A[idx] < A[idx - 1]) {
                idx++;
                des++;
            }
            if (inc > 0 && des > 0) {
                rst = Math.max(rst, inc + des + 1);
            }
        }
        return rst;
    }


    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        LongestMountaininArray solu = new LongestMountaininArray();
        System.out.println(solu.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(solu.longestMountain(new int[]{2, 2, 2}));
    }
}
