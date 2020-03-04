package LeetCode;


/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */

public class ReverseString {
    public void reverseString1(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int l, int r) {
        if (l > r) return;
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
        helper(s, l + 1, r - 1);
    }


    public static void main(String[] args) {
        char[] a = new char[]{'h', 'e', 'l', 'l', 'o'};
        String[] b = {"dog", "racecar", "car"};
        String[] c = {"c", "acc", "ccc"};
        ReverseString solu = new ReverseString();
        solu.reverseString(a);
        //System.out.println("1:" + solu.reverseString(a));
    }
}
