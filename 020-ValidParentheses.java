package LeetCode;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.add(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (st.isEmpty() || st.pop() != '(') {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if (st.empty() || st.pop() != '[') {
                        return false;
                    }
                } else {
                    if (st.empty() || st.pop() != '{') {
                        return false;
                    }
                }
            }
        }

        return st.empty();
    }

    public static void main(String[] args) {
        String[] a = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        ValidParentheses solu = new ValidParentheses();
        System.out.println("1:" + solu.isValid("()"));
        System.out.println("1:" + solu.isValid("()[]{}"));
        System.out.println("1:" + solu.isValid("(]"));
        System.out.println("1:" + solu.isValid("([)]"));
        System.out.println("1:" + solu.isValid("{[]}"));
    }
}
