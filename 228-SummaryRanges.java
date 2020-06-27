package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<>();
        int idx = 0;
        while (idx < nums.length) {
            int a = nums[idx];
            while (idx < nums.length - 1 && nums[idx] + 1 == nums[idx + 1]) {
                idx++;
            }
            if (a != nums[idx]) {
                rst.add(a + "->" + nums[idx]);
            } else {
                rst.add(String.valueOf(a));
            }
            idx++;
        }
        return rst;
    }
    
    public List<String> summaryRanges1(int[] nums) {
        List<String> rst = new ArrayList<>();
        int idx = 0;
        while (idx < nums.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[idx]);
            int end = idx + 1;
            while (end < nums.length && nums[end] - 1 == nums[end - 1]) {
                end++;
            }
            end--;
            if (end > 0 && nums[end] - nums[end - 1] == 1) {
                sb.append("->").append(nums[end]);
            }

            rst.add(sb.toString());
            idx = end + 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SummaryRanges solu = new SummaryRanges();
        System.out.println(solu.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(solu.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9, 10}));
    }

}
