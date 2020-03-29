package LeetCode;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rst = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        search(rst, set, candidates, target, new LinkedList<>());
        return rst;
    }

    public void search(List<List<Integer>> rst, HashSet<String> set, int[] candidates, int target, List<Integer> l) {
        if (target == 0) {
            List<Integer> tmp = new LinkedList<>(l);
            Collections.sort(tmp);
            if (!set.contains(tmp.toString())) {
                set.add(tmp.toString());
                rst.add(new LinkedList<>(tmp));
            }
            return;
        }
        if (target < 0) {
            return;
        }

        for (int candidate : candidates) {
            if (target - candidate < 0) {
                break;
            }
            target -= candidate;
            l.add(candidate);
            search(rst, set, candidates, target, l);
            l.remove(l.size() - 1);
            target += candidate;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            helper(rst, candidates, target - candidates[i], l, i);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CombinationSum solu = new CombinationSum();
        System.out.println(solu.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solu.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solu.combinationSum(new int[]{8, 7, 4, 3}, 11));
    }
}
