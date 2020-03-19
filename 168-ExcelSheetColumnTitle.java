package LeetCode;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle1(int n) {
        StringBuilder rst = new StringBuilder();
        while (n > 0) {
            rst.append((char) ((n - 1) % 26 + 'A'));
            n--;
            n /= 26;
        }
        return rst.reverse().toString();
    }

    public String convertToTitle(int n) {
        StringBuilder rst = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                rst.append('Z');
                n -= 26;
            } else {
                rst.append((char) (n % 26 - 1 + 'A'));
                n -= n % 26;
            }
            n /= 26;
        }
        return rst.reverse().toString();
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ExcelSheetColumnTitle solu = new ExcelSheetColumnTitle();
        System.out.println(solu.convertToTitle(1));
        System.out.println(solu.convertToTitle(26));
        System.out.println(solu.convertToTitle(28));
        System.out.println(solu.convertToTitle(701));
    }
}
