package LeetCode;

/*
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rst = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        if (map.containsKey("")) {
            int idx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i]) && map.get(words[i]) != idx) {
                    rst.add(Arrays.asList(idx, map.get(words[i])));
                    rst.add(Arrays.asList(map.get(words[i]), idx));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reverse) && map.get(reverse) != i) {
                rst.add(Arrays.asList(map.get(reverse), i));
            }

            String word = words[i];
            for (int j = 1; j < word.length(); j++) {
                if (isPalindrome(reverse.substring(0, j))) {
                    String sub_reverse = reverse.substring(j);
                    if (map.containsKey(sub_reverse) && map.get(sub_reverse) != i) {
                        rst.add(Arrays.asList(i, map.get(sub_reverse)));
                    }
                }
                if (isPalindrome(reverse.substring(j))) {
                    String sub_reverse = reverse.substring(0, j);
                    if (map.containsKey(sub_reverse) && map.get(sub_reverse) != i) {
                        rst.add(Arrays.asList(map.get(sub_reverse), i));
                    }
                }
            }
        }
        return rst;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        PalindromePairs solu = new PalindromePairs();
        System.out.println(solu.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }

    public static void testcase2() {
        PalindromePairs solu = new PalindromePairs();
        System.out.println(solu.palindromePairs(new String[]{"lls", "sssll"}));
    }
}
