package LeetCode;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ValidPalindrome solu = new ValidPalindrome();
        System.out.println(solu.isPalindrome("0P"));
    }
}
