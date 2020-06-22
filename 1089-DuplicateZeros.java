package LeetCode;

/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]


Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9
 */

public class DuplicateZeros {

    // 双指针
    public void duplicateZeros(int[] arr) {
        int slow = 0;
        int fast = 0;
        int n = arr.length;
        while (fast < n) {
            if (arr[slow] == 0) {
                fast++;
            }
            fast++;
            slow++;
        }
        fast--;
        slow--;
        while (slow >= 0) {
            if (fast < n) {
                arr[fast] = arr[slow];
            }
            if (arr[slow] == 0) {
                arr[--fast] = arr[slow];
            }
            fast--;
            slow--;
        }
    }

    public void duplicateZeros1(int[] arr) {
        int idx = 0;
        while (idx < arr.length) {
            if (arr[idx] == 0) {
                int i = arr.length - 1;
                while (i >= idx + 2) {
                    arr[i] = arr[i - 1];
                    i--;
                }
                if (idx + 1 < arr.length) {
                    arr[idx + 1] = 0;
                }
            }
            idx++;
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        DuplicateZeros solu = new DuplicateZeros();
        solu.duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
        solu.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }
}
