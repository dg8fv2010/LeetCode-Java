package LeetCode;

/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */

public class Sqrtx {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (mid > x / mid) { // 防止mid*mid导致的溢出
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        Sqrtx solu = new Sqrtx();
        System.out.println(solu.mySqrt(4));
    }

    public static void testcase2() {
        Sqrtx solu = new Sqrtx();
        System.out.println(solu.mySqrt(8));
    }
}
