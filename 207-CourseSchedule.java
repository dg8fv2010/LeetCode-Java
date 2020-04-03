package LeetCode;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            if (!map.containsKey(p[1])) {
                map.put(p[1], new LinkedList<>());
            }
            map.get(p[1]).add(p[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int curCourse = que.poll();
            List<Integer> toTake = map.getOrDefault(curCourse, null);
            if (toTake == null) {
                continue;
            }
            for (int n : map.get(curCourse)) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    que.add(n);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CourseSchedule solu = new CourseSchedule();
        System.out.println(solu.canFinish(2, new int[][]{{1, 0}}));
    }
}
