package LeetCode;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        int idx = 0;
        for (char c : pattern.toCharArray()) {
            if (idx >= str.length()) {
                return false;
            }
            if (!map.containsKey(c)) {
                if (map.containsValue(strs[idx])) {
                    return false;
                }
                map.put(c, strs[idx]);
            } else {
                if (!map.get(c).equals(strs[idx])) {
                    return false;
                }
            }
            idx++;
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        WordPattern solu = new WordPattern();
        System.out.println(solu.wordPattern("abba", "dog dog dog dog"));

    }
}
