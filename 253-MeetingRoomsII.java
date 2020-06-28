package LeetCode;


/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        q.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = q.poll();
            if (tmp[1] <= intervals[i][0]) {
                q.offer(intervals[i]);
            } else {
                tmp[1] = intervals[i][1];
            }
            q.offer(tmp);
        }

        return q.size();
    }

    public int minMeetingRooms1(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] i : intervals) {
            map.put(i[0], map.getOrDefault(i[0], 0) + 1);
            map.put(i[1], map.getOrDefault(i[1], 0) - 1);
        }

        int rst = 0;
        int rooms = 0;
        for (int i : map.values()) {
            rst = Math.max(rst, rooms += i);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MeetingRoomsII solu = new MeetingRoomsII();
        System.out.println(solu.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }
}
