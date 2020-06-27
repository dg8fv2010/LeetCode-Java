package LeetCode;

/*
Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.



Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.


Note:

0 <= A.length <= 40000
0 <= A[i] < 40000
 */

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinimumIncrementtoMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int cnt = 0;
        int need = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            cnt += value * Math.max(need - key, 0) + value * (value - 1) / 2;
            need = Math.max(need, key) + value;
        }
        return cnt;
    }

    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        int cnt = 0;
        int need = 0;
        for (int n : A) {
            cnt += Math.max(need - n, 0);
            need = Math.max(need, n) + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MinimumIncrementtoMakeArrayUnique solu = new MinimumIncrementtoMakeArrayUnique();
        System.out.println(solu.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
