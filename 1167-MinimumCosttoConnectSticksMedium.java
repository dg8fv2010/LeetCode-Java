package LeetCode;

/*
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.
You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Example 1:

Input: sticks = [2,4,3]
Output: 14

Example 2:

Input: sticks = [1,8,3,5]
Output: 30

Constraints:

1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4
 */

import java.util.PriorityQueue;

public class MinimumCosttoConnectSticksMedium {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : sticks) {
            q.offer(s);
        }

        int rst = 0;
        while (q.size() >= 2) {
            int a = q.poll();
            int b = q.poll();
            rst += (a + b);
            q.offer(a + b);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MinimumCosttoConnectSticksMedium solu = new MinimumCosttoConnectSticksMedium();
        System.out.println(solu.connectSticks(new int[]{2, 4, 3}));
    }
}
