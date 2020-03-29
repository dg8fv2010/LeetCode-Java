package LeetCode;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        Arrays.sort(nums);
        search(rst, nums, 0, new LinkedList<>());
        rst.add(new LinkedList<>());
        return rst;
    }

    public void search(List<List<Integer>> rst, int[] nums, int start, List<Integer> l) {
        if (l.size() > 0) {
            rst.add(new LinkedList<>(l));
        }

        for (int i = start; i < nums.length; i++) {
            l.add(nums[i]);
            search(rst, nums, i + 1, l);
            l.remove(l.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SubsetsII solu = new SubsetsII();
        System.out.println(solu.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
