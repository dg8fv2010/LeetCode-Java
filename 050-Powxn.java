package LeetCode;

/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

public class Powxn {
    public double myPow1(double x, int n) {
        x = n > 0 ? x : 1 / x;
        return helper(x, n);
    }

    public double helper(double x, int n) {
        double rst = 0;
        if (n == 0) {
            rst = 1;
        } else if (n == 1) {
            rst = x;
        } else {
            double tmp = helper(x, n / 2);
            rst = tmp * tmp;
            rst = n % 2 == 0 ? rst * 1 : rst * x;
        }
        return rst;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) return half * half;
        if (n > 0) return half * half * x;
        return half * half / x;
    }

    public double myPow(double x, int n) {
        double rst = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                rst *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / rst : rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        Powxn solu = new Powxn();
        System.out.println(solu.myPow(2.00000, 10));
        System.out.println(solu.myPow(2.10000, 3));
        System.out.println(solu.myPow(2.00000, -2));
    }
}
