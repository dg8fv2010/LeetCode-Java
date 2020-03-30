package LeetCode;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if ((int) window.get(c) == need.get(c)) {
                    cnt++;
                }
            }
            right++;
            while (cnt == need.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char c2 = s.charAt(left);
                if (need.containsKey(c2)) {
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if (window.get(c2) < need.get(c2)) {
                        cnt--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MinimumWindowSubstring solu = new MinimumWindowSubstring();
        System.out.println(solu.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solu.minWindow("a", "aa"));
    }
}
