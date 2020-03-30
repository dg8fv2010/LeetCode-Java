package LeetCode;

/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.



Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199.
             1 + 99 = 100, 99 + 100 = 199


Constraints:

num consists only of digits '0'-'9'.
1 <= num.length <= 35
Follow up:
How would you handle overflow for very large input integers?
 */

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }

        for (int i = 1; i < num.length(); i++) {
            String s1 = num.substring(0, i);
            if (s1.length() > 1 && s1.charAt(0) == '0') {
                return false;
            }
            for (int j = i + 1; j < num.length(); j++) {
                String s2 = num.substring(i, j);
                if (s2.length() > 1 && s2.charAt(0) == '0') {
                    break;
                }
                if (isValid(s1, s2, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(String s1, String s2, String s) {
        if (s.length() == 0) {
            return true;
        }
        long n1 = Long.valueOf(s1);
        long n2 = Long.valueOf(s2);
        String sum = String.valueOf(n1 + n2);
        if (!s.startsWith(sum)) {
            return false;
        }
        String new_s2 = sum;
        String new_s1 = s2;
        return isValid(new_s1, new_s2, s.substring(sum.length()));
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        AdditiveNumber solu = new AdditiveNumber();
        System.out.println(solu.isAdditiveNumber("112358"));
        System.out.println(solu.isAdditiveNumber("199100199"));
        System.out.println(solu.isAdditiveNumber("101"));
    }
}
