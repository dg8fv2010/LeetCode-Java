package LeetCode;

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings {
    public String addStrings(String num1, String num2) {
        String rst = "";
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        while (idx1 >= 0 && idx2 >= 0) {
            int tmp = (num1.charAt(idx1) - '0') + (num2.charAt(idx2) - '0') + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            rst = (char) ('0' + tmp) + rst;
            idx1--;
            idx2--;
        }

        while (idx1 >= 0) {
            int tmp = (num1.charAt(idx1) - '0') + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            rst = (char) ('0' + tmp) + rst;
            idx1--;
        }

        while (idx2 >= 0) {
            int tmp = (num2.charAt(idx2) - '0') + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            rst = (char) ('0' + tmp) + rst;
            idx2--;
        }
        if (carry > 0) {
            rst = String.valueOf(carry) + rst;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        AddStrings solu = new AddStrings();
        solu.addStrings("9", "1");
    }
}
