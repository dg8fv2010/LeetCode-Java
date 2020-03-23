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
        String rst = "";
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        int begin = 0;
        int end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    cnt++;
                }
            }
            while (cnt == t.length()) {
                if (minLen > end - begin + 1) {
                    minLen = end - begin + 1;
                    rst = s.substring(begin, end + 1);
                }

                char cc = s.charAt(begin);
                if (map.containsKey(cc)) {
                    map.put(cc, map.get(cc) + 1);
                    if (map.get(cc) > 0) {
                        cnt--;
                    }
                }
                begin++;
            }
            end++;
        }
        return rst;
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
