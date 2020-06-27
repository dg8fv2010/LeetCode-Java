package LeetCode;

/*
Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), 
where h is the height of the person and k is the number of people in front of this person 
who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });

        List<int[]> l = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            l.add(people[i][1], people[i]);
        }
        return l.toArray(people);
    }

    public int[][] reconstructQueue1(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        int m = people.length;
        int n = people[0].length;
        int[][] rst = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rst[i][j] = -1;
            }
        }
        Arrays.sort(people, (ints, t1) -> {
            if (ints[0] == t1[0]) {
                return ints[1] - t1[1];
            } else {
                return ints[0] - t1[0];
            }
        });

        for (int i = 0; i < people.length; i++) {
            int h = people[i][0];
            int k = people[i][1];

            int cnt = 0;
            int j = 0;
            for (j = 0; j < rst.length; j++) {
                if (cnt == k && rst[j][0] == -1) {
                    break;
                }
                if (rst[j][0] == -1 || rst[j][0] >= h) {
                    cnt++;
                }

            }
            rst[j][0] = h;
            rst[j][1] = k;
        }

        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        QueueReconstructionbyHeight solu = new QueueReconstructionbyHeight();
        //System.out.println(solu.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
        System.out.println(solu.reconstructQueue(new int[][]{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}}));
    }
}
