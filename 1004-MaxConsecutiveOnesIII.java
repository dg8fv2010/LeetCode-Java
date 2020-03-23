package LeetCode;

/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.



Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.


Note:

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1
 */

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int begin = 0;
        int end = 0;
        int rst = 0;

        int cnt = 0;
        while (end < A.length) {
            cnt += A[end] == 0 ? 1 : 0;
            if (cnt > K) {
                while (begin < end && A[begin] == 1) {
                    begin++;
                }
                cnt--;
                begin++;
            }
            rst = Math.max(rst, end - begin + 1);
            end++;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MaxConsecutiveOnesIII solu = new MaxConsecutiveOnesIII();
        System.out.println(solu.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(solu.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
