package LeetCode;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 */

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = 2; // 用int会出错
        while (r * r < num) {
            l = r;
            r *= 2;
        }

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long tmp = mid * mid;
            if (tmp < num) {
                l = mid + 1;
            } else if (tmp > num) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ValidPerfectSquare solu = new ValidPerfectSquare();
        System.out.println(solu.isPerfectSquare(14));
    }
}
