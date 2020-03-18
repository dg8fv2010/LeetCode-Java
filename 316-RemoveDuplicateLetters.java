package LeetCode;

/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        StringBuilder rst = new StringBuilder();
        int[] cnt = new int[26];
        boolean[] used = new boolean[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            cnt[c - 'a']--;
            if (used[c - 'a']) {
                continue;
            }

            while (rst.length() > 0 &&
                    rst.charAt(rst.length() - 1) > c &&
                    cnt[rst.charAt(rst.length() - 1) - 'a'] > 0) {
                used[rst.charAt(rst.length() - 1) - 'a'] = false;
                rst.deleteCharAt(rst.length() - 1);
            }
            rst.append(c);
            used[c - 'a'] = true;
        }
        return rst.toString();
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        RemoveDuplicateLetters solu = new RemoveDuplicateLetters();
        System.out.println(solu.removeDuplicateLetters("cbacdcbc"));
    }
}
