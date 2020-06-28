package LeetCode;

import java.util.Arrays;

/*
Given an array of citations (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
             received 3, 0, 6, 1, 5 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.

Accepted
 */

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                arr[n]++;
            } else {
                arr[c]++;
            }
        }

        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += arr[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        int mincit = citations[n - 1];
        int rst = 0;
        for (int i = n - 1; i >= 0; i--) {
            mincit = Math.min(mincit, citations[i]);
            if (mincit >= n - i) {
                rst = n - i;
            } else {
                break;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        HIndex solu = new HIndex();
        System.out.println(solu.hIndex(new int[]{3, 0, 6, 5, 1}));
    }
}