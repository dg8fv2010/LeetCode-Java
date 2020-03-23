package LeetCode;

/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
 */

import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
    // 159-Longest Substring with At Most Two Distinct Characters
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int rst = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            rst = Math.max(rst, r - l + 1);
            r++;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        LongestSubstringwithAtMostKDistinctCharacters solu = new LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(solu.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(solu.lengthOfLongestSubstringKDistinct("ccaabbb", 2));
    }
}
