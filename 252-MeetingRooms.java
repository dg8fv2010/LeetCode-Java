package LeetCode;


/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.
 */

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i - 1];
            int[] cur = intervals[i];
            if (prev[1] >= cur[0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MeetingRooms solu = new MeetingRooms();
        System.out.println(solu.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(solu.canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }
}
