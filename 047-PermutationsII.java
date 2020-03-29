package LeetCode;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(rst, new LinkedList<>(), nums, 0, visited);
        return rst;
    }

    public void helper(List<List<Integer>> rst, List<Integer> l, int[] nums, int cur, boolean[] visited) {
        if (l.size() == nums.length) {
            rst.add(new LinkedList<>(l));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            l.add(nums[i]);
            visited[i] = true;
            helper(rst, l, nums, i + 1, visited);
            visited[i] = false;
            l.remove(l.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        search(rst, new LinkedList<>(), nums, map, new HashSet<>());
        return rst;
    }

    public void search(List<List<Integer>> rst, List<Integer> l, int[] nums, HashMap<Integer, Integer> map, HashSet<String> visited) {
        if (l.size() == nums.length) {
            if (!visited.contains(l.toString())) {
                visited.add(l.toString());
                rst.add(new LinkedList<>(l));
            }
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            HashMap<Integer, Integer> tmp = new HashMap<>(map);
            tmp.put(entry.getKey(), entry.getValue() - 1);
            if (tmp.get(entry.getKey()) == 0) {
                tmp.remove(entry.getKey());
            }
            l.add(entry.getKey());
            search(rst, l, nums, tmp, visited);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        PermutationsII solu = new PermutationsII();
        System.out.println(solu.permuteUnique(new int[]{1, 1, 2}));
    }
}
