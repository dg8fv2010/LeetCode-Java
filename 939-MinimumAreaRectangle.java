package LeetCode;

/*
Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.



Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2


Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
 */

import java.util.HashMap;
import java.util.HashSet;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        // map的key保存x，value保存y的集合
        // 遍历points，找到对角的两个点，判断剩余两个点是否存在，存在则计算
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (!map.containsKey(points[i][0])) {
                map.put(points[i][0], new HashSet<>());
            }
            map.get(points[i][0]).add(points[i][1]);
        }

        int rst = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    int tmp = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
                    rst = Math.min(rst, tmp);
                }
            }
        }

        return rst == Integer.MIN_VALUE ? 0 : rst;
    }
}
