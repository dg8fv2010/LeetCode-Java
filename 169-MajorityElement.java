package LeetCode;

/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int rst = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                rst = entry.getKey();
                break;
            }
        }
        return rst;
    }

    public int majorityElement(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                ++cnt;
            } else if (num == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MajorityElement solu = new MajorityElement();
        System.out.println(solu.majorityElement(new int[]{1, 2, 2, 1, 1, 1, 1}));
    }
}
