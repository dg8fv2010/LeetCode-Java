package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.
 */

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] i : intervals) {
            if (map.containsKey(i[0])) {
                map.put(i[0], Math.max(map.get(i[0]), i[1]));
            } else {
                map.put(i[0], i[1]);
            }
        }
        List<int[]> rst = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int a = entry.getKey();
            int b = entry.getValue();
            if (rst.size() == 0) {
                rst.add(new int[]{a, b});
            } else {
                int[] last = rst.get(rst.size() - 1);
                if (last[1] >= b) {
                    continue;
                }
                if (last[1] >= a) {
                    last[1] = b;
                } else {
                    rst.add(new int[]{a, b});
                }
            }
        }

        int[][] arr = new int[rst.size()][2];
        for (int i = 0; i < rst.size(); i++) {
            arr[i][0] = rst.get(i)[0];
            arr[i][1] = rst.get(i)[1];
        }
        return arr;
    }
}
