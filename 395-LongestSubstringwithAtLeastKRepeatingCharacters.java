package LeetCode;

/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    // 先统计所有字母出现的次数
    // 再次遍历字符串，如果当前字符的数量小于k
    // 递归计算begin和end组成的substring的长度
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        boolean fullString = true;
        for (int n : arr) {
            if (n > 0 && n < k) {
                fullString = false;
            }
        }
        if (fullString) {
            return s.length();
        }

        int begin = 0;
        int end = 0;
        int rst = 0;
        while (end < s.length()) {
            if (arr[s.charAt(end) - 'a'] < k) {
                rst = Math.max(rst, longestSubstring(s.substring(begin, end), k));
                begin = end + 1;
            }
            end++;
        }
        rst = Math.max(rst, longestSubstring(s.substring(begin), k));
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        LongestSubstringwithAtLeastKRepeatingCharacters solu = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(solu.longestSubstring("cabca", 2));
    }

}
