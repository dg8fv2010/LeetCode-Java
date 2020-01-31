package LeetCode;

/*
Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.


Follow up:

For C programmers, try to solve it in-place in O(1) extra space.
 */

public class ReverseWordsinaString {

    // 考虑各种异常
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String rst = "";
        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }
            String tmp = "";
            while (idx < s.length() && s.charAt(idx) != ' ') {
                tmp += s.charAt(idx);
                idx++;
            }
            if (!tmp.equals("")) {
                rst = tmp + ' ' + rst;
            }

        }
        return rst.equals("") ? "" : rst.substring(0, rst.length() - 1);
    }

    public static void main(String[] args) {
        String a = "the sky is blue";
        String b = "  hello world!  ";
        String c = "a good   example";
        String d = " ";
        ReverseWordsinaString solu = new ReverseWordsinaString();
        System.out.println("1:" + solu.reverseWords(d));
    }
}
