package LeetCode;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> rst = new LinkedList<>();
        if (digits == null || digits.length() == 0) return rst;
        search(map, digits, 0, "", rst);
        return rst;
    }

    public void search(HashMap<Integer, String> map, String digits, int idx, String s, List<String> rst) {
        if (idx == digits.length()) {
            rst.add(s);
            return;
        }

        String letters = map.get(digits.charAt(idx) - '0');
        for (int j = 0; j < letters.length(); j++) {
            s += letters.charAt(j);
            search(map, digits, idx + 1, s, rst);
            s = s.substring(0, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        LetterCombinationsofaPhoneNumber solu = new LetterCombinationsofaPhoneNumber();
        System.out.println(solu.letterCombinations("23"));
    }
}
