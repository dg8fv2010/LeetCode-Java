package LeetCode;

/*
Given an array arr, replace every element in that array with
the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 */

public class ReplaceElementswithGreatestElementonRightSide {

    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] rst = new int[n];
        int maxVal = -1;
        for (int i = n - 1; i >= 0; i--) {
            rst[i] = maxVal;
            maxVal = Math.max(maxVal, arr[i]);
        }
        return rst;
    }

    public int[] replaceElements1(int[] arr) {
        int i = 0;
        int n = arr.length;
        int curMax = i;
        while (i < n) {
            if (i == curMax) {
                curMax = i + 1;
                int tmp = curMax;
                while (tmp < n) {
                    if (arr[tmp] > arr[curMax]) {
                        curMax = tmp;
                    }
                    tmp++;
                }
            } else {
                if (curMax == n) {
                    arr[i] = -1;
                    break;
                }
                arr[i] = arr[curMax];
                i++;
            }
        }
        return arr;
    }
}
