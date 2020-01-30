package LeetCode;

/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        String rst = "";
        int idx_a = a.length() - 1;
        int idx_b = b.length() - 1;
        int carry = 0;

        while (idx_a >= 0 || idx_b >= 0) {
            if (idx_a >= 0) {
                carry += a.charAt(idx_a) - '0';
                idx_a--;
            }
            if (idx_b >= 0) {
                carry += b.charAt(idx_b) - '0';
                idx_b--;
            }
            rst = (char) (carry % 2 + '0') + rst;
            carry /= 2;
        }
        if (carry == 1) {
            rst = '1' + rst;
        }

        return rst;
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        AddBinary solu = new AddBinary();
        System.out.println("1:" + solu.addBinary(a, b));
    }
}
