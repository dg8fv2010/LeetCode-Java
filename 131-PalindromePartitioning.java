package LeetCode;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new LinkedList<>();
        search(s, rst, new LinkedList<>());
        return rst;
    }

    public void search(String s, List<List<String>> rst, List<String> l) {
        if (s.length() == 0) {
            rst.add(new LinkedList<>(l));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                l.add(s.substring(0, i));
                search(s.substring(i), rst, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        PalindromePartitioning solu = new PalindromePartitioning();
        System.out.println(solu.partition("aab"));
    }
}
