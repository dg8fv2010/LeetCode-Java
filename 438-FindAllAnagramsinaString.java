package LeetCode;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsinaString {
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        HashSet<Character> set = new HashSet<>();
        List<Integer> rst = new LinkedList<>();
        int[] total = new int[26];
        for (char c : p.toCharArray()) {
            total[c - 'a']++;
            set.add(c);
        }
        int[] arr = Arrays.copyOfRange(total, 0, 26);
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            // 如果当前字符不在p中，l直接跳到下一个字符
            if (!set.contains(c)) {
                l = r + 1;
                r = r + 1;
                arr = Arrays.copyOfRange(total, 0, 26);
                continue;
            }
            if (arr[c - 'a'] == 0) {
                arr[s.charAt(l) - 'a']++;
                l++;
            } else if (arr[c - 'a'] > 0) {
                arr[c - 'a']--;
                boolean flag = true;
                for (int i = 0; i < 26; i++) {
                    if (arr[i] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    rst.add(l);
                    arr[s.charAt(l) - 'a']++;
                    l++;
                }
                r++;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FindAllAnagramsinaString solu = new FindAllAnagramsinaString();
        System.out.println(solu.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solu.findAnagrams("abab", "ab"));
    }
}
