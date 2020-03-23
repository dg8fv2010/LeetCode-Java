package LeetCode;

/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    // 340-Longest Substring with At Most K Distinct Characters
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l = 0;
        int r = 0;
        int rst = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
                rst = Math.max(rst, r - l + 1);
                r++;
            } else {
                if (map.size() < 2) {
                    map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                    rst = Math.max(rst, r - l + 1);
                    r++;
                } else {
                    while (map.size() >= 2) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                        if (map.get(s.charAt(l)) == 0) {
                            map.remove(s.charAt(l));
                        }
                        l++;
                    }
                    map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                    r++;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        LongestSubstringwithAtMostTwoDistinctCharacters solu = new LongestSubstringwithAtMostTwoDistinctCharacters();
        System.out.println(solu.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(solu.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}