package LeetCode;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

Example:

Input: low = "50", high = "100"
Output: 3
Explanation: 69, 88, and 96 are three strobogrammatic numbers.
Note:
Because the range might be a large number, the lowand high numbers are represented as string.
 */

public class StrobogrammaticNumberIII {
    int cnt = 0;

    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            helper(low, high, "", i);
            helper(low, high, "0", i);
            helper(low, high, "1", i);
            helper(low, high, "8", i);
        }
        return this.cnt;
    }

    public void helper(String low, String high, String s, int len) {
        if (s.length() >= len) {
            if (s.length() != len || (s.length() != 1 && s.charAt(0) == '0')) {
                return;
            }
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            this.cnt++;
        }
        helper(low, high, "0" + s + "0", len);
        helper(low, high, "1" + s + "1", len);
        helper(low, high, "6" + s + "9", len);
        helper(low, high, "8" + s + "8", len);
        helper(low, high, "9" + s + "6", len);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        StrobogrammaticNumberIII solu = new StrobogrammaticNumberIII();
        System.out.println(solu.strobogrammaticInRange("50", "100"));
    }
}
