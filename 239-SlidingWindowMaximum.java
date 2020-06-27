package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an array nums, there is a sliding window of size k which is moving from
the very left of the array to the very right. You can only see the k numbers in the window.
Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] rst = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                rst[idx++] = nums[q.peek()];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SlidingWindowMaximum solu = new SlidingWindowMaximum();
        System.out.println(solu.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
    }
}
