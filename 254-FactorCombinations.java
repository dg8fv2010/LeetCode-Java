package LeetCode;

/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1:

Input: 1
Output: []
Example 2:

Input: 37
Output:[]
Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 */

import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rst = new LinkedList<>();
        List<Integer> candidates = new LinkedList<>();
        int i = 2;
        while (n / 2 >= i) {
            if (n % i == 0) {
                candidates.add(i);
            }
            i++;
        }
        if (candidates.size() == 0) {
            return rst;
        }
        search(rst, candidates, 0, n, new LinkedList<>());
        return rst;
    }

    public void search(List<List<Integer>> rst, List<Integer> candidates, int cur, int n, List<Integer> l) {
        if (1 == n) {
            rst.add(new LinkedList<>(l));
            return;
        }

        for (int i = cur; i < candidates.size(); i++) {
            int num = candidates.get(i);
            if (n / num < 1) {
                break;
            }
            if (n % num != 0) {
                continue;
            }
            l.add(num);
            search(rst, candidates, i, n / num, l);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FactorCombinations solu = new FactorCombinations();
        System.out.println(solu.getFactors(1));
        System.out.println(solu.getFactors(37));
        System.out.println(solu.getFactors(12));
        System.out.println(solu.getFactors(32));
    }
}
