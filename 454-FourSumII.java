package LeetCode;

/*
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    // 用两个hashmap，分别保存A+B和C+D的和
    // 再遍历第一个hashmap，看第二个hashmap里面有没有对应的相反数
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapAB = new HashMap<>();
        Map<Integer, Integer> mapCD = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int sum = A[i] + B[j];
                if (mapAB.containsKey(sum)) {
                    mapAB.replace(sum, mapAB.get(sum) + 1);
                } else {
                    mapAB.put(sum, 1);
                }
                sum = C[i] + D[j];
                if (mapCD.containsKey(sum)) {
                    mapCD.replace(sum, mapCD.get(sum) + 1);
                } else {
                    mapCD.put(sum, 1);
                }
            }
        }

        int rst = 0;
        for (Map.Entry<Integer, Integer> entry : mapAB.entrySet()) {
            rst += entry.getValue() * mapCD.getOrDefault(-(entry.getKey()), 0);
        }
        return rst;
    }

    public static void testcase1() {
        FourSumII solu = new FourSumII();
        System.out.println(solu.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
