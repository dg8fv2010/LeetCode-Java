package LeetCode;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public int calculate(int n) {
        int rst = 0;
        while (n > 0) {
            rst = rst + (n % 10) * (n % 10);
            n = n / 10;
        }
        return rst;
    }

    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = this.calculate(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    // 非快乐数的循环里一定会出现4
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && n != 4) {
            n = this.calculate(n);
        }
        return n == 1;
    }

    // 非快乐数会出现循环，可以用快慢指针
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (true) {
            slow = this.calculate(slow);
            fast = this.calculate(fast);
            fast = this.calculate(fast);
            if (slow == fast) break;
        }
        return slow == 1;
    }

    public static void testcase1() {
        HappyNumber solu = new HappyNumber();
        boolean c = solu.isHappy(19);
    }

    public static void main(String[] args) {
        testcase1();
    }
}
