package LeetCode;

/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A,
26-Remove Duplicates from Sorted Arrayfollowed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
 */

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int even = 0;
        int cur = 0;
        while (cur < A.length) {
            if (A[cur] % 2 == 0) {
                int tmp = A[cur];
                A[cur] = A[even];
                A[even] = tmp;
                even++;
            }
            cur++;
        }
        return A;
    }
}
