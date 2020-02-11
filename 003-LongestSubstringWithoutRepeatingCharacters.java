package LeetCode;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // 滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    // 同样是滑动窗口
    // 这次发现相同的字母时，i直接从上一个相同字母所在的位置开始
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public static void testcase1() {
        LongestSubstringWithoutRepeatingCharacters solu = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solu.lengthOfLongestSubstring("abcabcbb"));
    }

    public static void testcase2() {
        LongestSubstringWithoutRepeatingCharacters solu = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solu.lengthOfLongestSubstring("bbbbb"));
    }

    public static void testcase3() {
        LongestSubstringWithoutRepeatingCharacters solu = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solu.lengthOfLongestSubstring("pwwkew"));
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
    }
}
