package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
Given a non-empty array of non-negative integers nums,
the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums,
that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */

public class DegreeofanArray {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new TreeSet<>());
            }
            map.get(nums[i]).add(i);
        }

        int degree = 0;
        int rst = Integer.MAX_VALUE;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            TreeSet<Integer> set = entry.getValue();
            if (set.size() > degree) {
                degree = set.size();
                rst = set.last() - set.first() + 1;
            } else if (set.size() == degree) {
                degree = set.size();
                rst = Math.min(rst, set.last() - set.first() + 1);
            }
        }

        return rst;
    }
}
