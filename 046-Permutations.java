package LeetCode;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            list.add(num);
            set.remove(num);
            search(rst, list, set);
            list.remove(list.size() - 1);
            set.add(num);
        }
        return rst;
    }

    public void search(List<List<Integer>> rst, List<Integer> list, Set<Integer> set) {
        if (set.isEmpty()) {
            rst.add(new LinkedList<>(list));
            return;
        }

        for (int s : set) {
            list.add(s);
            Set<Integer> tmp = new HashSet<>(set);
            tmp.remove(s);
            search(rst, list, tmp);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new LinkedList<>();
        dfs(rst, nums, list, visited);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            rst.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(rst, nums, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        Permutations solu = new Permutations();
        System.out.println(solu.permute(new int[]{1, 2, 3}));
    }
}
