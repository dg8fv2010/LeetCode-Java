package LeetCode;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rst = new LinkedList<>();
        helper(rst, candidates, target, new LinkedList<>(), 0);
        return rst;
    }

    public void helper(List<List<Integer>> rst, int[] candidates, int target, List<Integer> l, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            rst.add(new LinkedList<>(l));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            l.add(candidates[i]);
            helper(rst, candidates, target - candidates[i], l, i + 1);
            l.remove(l.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CombinationSumII solu = new CombinationSumII();
        System.out.println(solu.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(solu.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

}
