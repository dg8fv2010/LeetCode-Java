package LeetCode;

/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

public class ValidPalindromeII {
    int cnt = 0;

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (cnt > 0) {
                    return false;
                }
                cnt++;
                return validPalindrome(s.substring(l + 1, r + 1)) || validPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ValidPalindromeII solu = new ValidPalindromeII();
        //System.out.println(solu.validPalindrome("cupjjpucu"));

        System.out.println(solu.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
