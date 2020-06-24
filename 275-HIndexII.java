package LeetCode;

/*
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
             received 0, 1, 3, 5, 6 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?
 */

public class HIndexII {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (n - mid == citations[mid]) {
                return n - mid;
            } else if (n - mid < citations[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return n - l;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        HIndexII solu = new HIndexII();
        System.out.println(solu.hIndex(new int[]{0}));
        System.out.println(solu.hIndex(new int[]{100}));
        System.out.println(solu.hIndex(new int[]{0, 1, 3, 5, 6}));
    }
}
