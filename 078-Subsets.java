package LeetCode;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
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
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        Subsets solu = new Subsets();
        System.out.println(solu.subsets(new int[]{1, 2, 3}));
    }
}
