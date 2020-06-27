package LeetCode;

import java.util.HashSet;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int rst = 0;
        for (int n : nums) {
            int l = n - 1;
            int r = n + 1;
            int cnt = 1;
            set.remove(n);
            while (set.contains(l)) {
                set.remove(l);
                l--;
                cnt++;
            }
            while (set.contains(r)) {
                set.remove(r);
                r++;
                cnt++;
            }
            rst = Math.max(rst, cnt);
        }

        return rst;
    }
}
