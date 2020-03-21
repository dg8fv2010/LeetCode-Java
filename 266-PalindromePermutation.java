package LeetCode;

/*
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    // 没有奇数，或者s长度为1且只有一个奇数
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddcnt = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() % 2 == 1) {
                oddcnt++;
            }
        }
        return oddcnt == 0 || (s.length() % 2 == 1 && oddcnt == 1);
    }
}
