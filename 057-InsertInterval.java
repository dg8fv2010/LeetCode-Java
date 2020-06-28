package LeetCode;

import java.util.LinkedList;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.
 */

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }
        List<int[]> l = new LinkedList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            l.add(new int[] { intervals[i][0], intervals[i][1] });
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        l.add(newInterval);

        while (i < intervals.length) {
            l.add(new int[] { intervals[i][0], intervals[i][1] });
            i++;
        }

        int[][] rst = new int[l.size()][2];
        for (i = 0; i < l.size(); i++) {
            rst[i][0] = l.get(i)[0];
            rst[i][1] = l.get(i)[1];
        }

        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        InsertInterval solu = new InsertInterval();
        // System.out.println(solu.insert(new int[][]{{1, 5}}, new int[]{6, 8}));
        // System.out.println(solu.insert(new int[][]{{1, 5}}, new int[]{5, 7}));
        // System.out.println(solu.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2,
        // 5}));
        System.out.println(
                solu.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }));
    }
}
