package LeetCode;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int rst = 0;
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }
        while (idx >= 0 && s.charAt(idx) != ' ') {
            rst++;
            idx--;
        }

        return rst;
    }
}
