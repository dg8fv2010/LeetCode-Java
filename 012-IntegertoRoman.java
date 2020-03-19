package LeetCode;
/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder rst = new StringBuilder();
        char[] roman = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] value = new int[]{1000, 500, 100, 50, 10, 5, 1};

        for (int n = 0; n < 7; n += 2) {
            int x = num / value[n];
            if (x < 4) {
                for (int i = 0; i < x; i++) {
                    rst.append(roman[n]);
                }
            } else if (x == 4) {
                rst.append(roman[n]).append(roman[n - 1]);
            } else if (x > 4 && x < 9) {
                rst.append(roman[n - 1]);
                for (int i = 6; i <= x; i++) {
                    rst.append(roman[n]);
                }
            } else if (x == 9) {
                rst.append(roman[n]).append(roman[n - 2]);
            }
            num %= value[n];
        }
        return rst.toString();
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        IntegertoRoman solu = new IntegertoRoman();
        System.out.println(solu.intToRoman(3));
        System.out.println(solu.intToRoman(4));
        System.out.println(solu.intToRoman(9));
        System.out.println(solu.intToRoman(58));
        System.out.println(solu.intToRoman(1994));
    }
}
