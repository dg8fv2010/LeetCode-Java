package LeetCode;

/*
Given an array A of integers, return the number of (contiguous, non-empty) subarrays that
have a sum divisible by K.



Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


Note:

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000
 */

public class SubarraySumsDivisiblebyK {

    public int subarraysDivByK(int[] A, int K) {
        // 如果presum[i]%K==presum[j]%K
        // 那么i和j之间的和会被K整除
        int[] arr = new int[A.length];
        int rst = 0;
        arr[0] = 1;
        for (int i = 0; i < A.length; i++) {
            if (i > 0) {
                A[i] += A[i - 1];
            }
            int tmp = A[i] % K;
            int mod = tmp < 0 ? tmp + K : tmp;
            rst += arr[mod];
            arr[mod]++;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SubarraySumsDivisiblebyK solu = new SubarraySumsDivisiblebyK();
        System.out.println(solu.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
    }
}
