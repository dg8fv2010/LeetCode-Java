package LeetCode;

/*
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> rst = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddcnt = 0;
        char odd = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddcnt++;
                odd = entry.getKey();
            }
        }
        if (oddcnt > 1) {
            return rst;
        }

        if (oddcnt == 1) {
            helper(rst, map, String.valueOf(odd), s.length());
        } else {
            helper(rst, map, "", s.length());
        }
        return rst;
    }

    public void helper(List<String> rst, Map<Character, Integer> map, String s, int n) {
        if (s.length() == n) {
            rst.add(s);
            return;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            s = entry.getKey() + s + entry.getKey();
            HashMap<Character, Integer> m = new HashMap<>(map);
            m.put(entry.getKey(), entry.getValue() - 2);
            if (m.get(entry.getKey()) == 0) {
                m.remove(entry.getKey());
            }
            helper(rst, m, s, n);
            s = s.substring(1, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        PalindromePermutationII solu = new PalindromePermutationII();
        System.out.println(solu.generatePalindromes("aabb"));
    }
}
