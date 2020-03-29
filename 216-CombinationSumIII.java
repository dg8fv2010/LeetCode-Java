package LeetCode;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new LinkedList<>();
        search(rst, k, n, 1, new LinkedList<>());
        return rst;
    }

    public void search(List<List<Integer>> rst, int k, int n, int cur, List<Integer> l) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            if (l.size() == k) {
                rst.add(new LinkedList<>(l));
            }
            return;
        }
        for (int i = cur; i <= 9; i++) {
            if (n - i < 0) {
                break;
            }
            l.add(i);
            search(rst, k, n - i, i + 1, l);
            l.remove(l.size() - 1);
        }
    }


}
