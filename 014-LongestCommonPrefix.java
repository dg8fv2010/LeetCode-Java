package LeetCode;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String rst = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(rst) != 0) {
                rst = rst.substring(0, rst.length() - 1);
            }
            if (rst.length() == 0) {
                return "";
            }
        }

        return rst;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"dog", "racecar", "car"};
        String[] c = {"c", "acc", "ccc"};
        LongestCommonPrefix solu = new LongestCommonPrefix();
        System.out.println("1:" + solu.longestCommonPrefix1(c));
    }
}
