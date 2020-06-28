package LeetCode;

/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that is either empty,
or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */

import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int ai = 0;
        int bi = 0;
        List<int[]> list = new LinkedList<>();
        while (ai < m && bi < n) {
            if (A[ai][1] < B[bi][0]) {
                ai++;
            } else if (A[ai][0] > B[bi][1]) {
                bi++;
            } else {
                int start = Math.max(A[ai][0], B[bi][0]);
                int end = Math.min(A[ai][1], B[bi][1]);
                list.add(new int[]{start, end});
                if (A[ai][1] < B[bi][1]) {
                    ai++;
                } else {
                    bi++;
                }
            }
        }

        int[][] rst = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            rst[i][0] = list.get(i)[0];
            rst[i][1] = list.get(i)[1];
        }
        return rst;
    }
}
