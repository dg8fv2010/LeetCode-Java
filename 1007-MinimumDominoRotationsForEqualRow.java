package LeetCode;

/*
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same,
or all the values in B are the same.

If it cannot be done, return -1.



Example 1:



Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation:
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2,
as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation:
In this case, it is not possible to rotate the dominoes to make one row of values equal.


Note:

1 <= A[i], B[i] <= 6
2 <= A.length == B.length <= 20000
 */

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        // 统计出现次数最多的数，小于A的长度返回-1
        // 分别遍历AB，统计变换次数
        int[] arr = new int[7];
        for (int a : A) {
            arr[a]++;
        }
        for (int b : B) {
            arr[b]++;
        }
        int target = 0;
        for (int i = 0; i < 7; i++) {
            if (arr[i] > arr[target]) {
                target = i;
            }
        }
        if (arr[target] < A.length) {
            return -1;
        }

        int cnt1 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                continue;
            }
            if (B[i] == target) {
                cnt1++;
            } else {
                cnt1 = -1;
                break;
            }
        }

        int cnt2 = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == target) {
                continue;
            }
            if (A[i] == target) {
                cnt2++;
            } else {
                cnt2 = -1;
                break;
            }
        }

        if (cnt1 >= 0 && cnt2 >= 0) {
            return Math.min(cnt1, cnt2);
        } else if (cnt1 < 0 && cnt2 < 0) {
            return -1;
        } else {
            return Math.max(cnt1, cnt2);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MinimumDominoRotationsForEqualRow solu = new MinimumDominoRotationsForEqualRow();
        System.out.println(solu.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
    }
}
