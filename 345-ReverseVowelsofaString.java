package LeetCode;

/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */

import java.util.HashSet;

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        StringBuilder rst = new StringBuilder(s);
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');

        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            while (l <= r && !set.contains(s.charAt(l))) {
                l++;
            }
            while (l <= r && !set.contains(s.charAt(r))) {
                r--;
            }
            if (l <= r && (s.charAt(l) != s.charAt(r))) {
                char tmp = s.charAt(l);
                rst.setCharAt(l, s.charAt(r));
                rst.setCharAt(r, tmp);
            }
            l++;
            r--;
        }

        return rst.toString();
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ReverseVowelsofaString solu = new ReverseVowelsofaString();
        System.out.println(solu.reverseVowels(" "));
        System.out.println(solu.reverseVowels("A man, a plan, a canal: Panama"));
    }
}
