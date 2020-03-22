package LeetCode;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int rst = 0;
        int start = 0;
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                st.push(idx);
            } else {
                if (st.isEmpty()) {
                    start = idx + 1;
                } else {
                    st.pop();
                    rst = st.isEmpty() ? Math.max(rst, idx - start + 1) : Math.max(rst, idx - st.peek());
                }
            }
            idx++;
        }
        return rst;
    }

    // 从左向右遍历，统计左右括号出现的次数
    // 再反向遍历，统计次数
    public int longestValidParentheses1(String s) {
        int l = 0;
        int r = 0;
        int rst = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
                r++;
            }
            if (l == r) {
                rst = Math.max(rst, 2 * l);
            }
            if (l < r) {
                l = 0;
                r = 0;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                rst = Math.max(rst, 2 * l);
            }
            if (l > r) {
                l = 0;
                r = 0;
            }
        }
        return rst;
    }
}
