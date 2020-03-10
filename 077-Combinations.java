package LeetCode;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(1, n, k, list, rst);
        return rst;
    }

    public void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> rst) {
        if (list.size() == k) {
            rst.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(i + 1, n, k, list, rst);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        testcase2();
    }

    public static void testcase1() {
        Combinations solu = new Combinations();
        solu.combine(4, 2);
    }

    public static void testcase2() {
        Combinations solu = new Combinations();
        solu.combine(1, 1);
    }
}
