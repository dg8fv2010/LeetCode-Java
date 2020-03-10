package LeetCode;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis1(int n) {
        String s = "";
        List<String> list = new LinkedList<>();
        helper(n, s, n, n, list);
        return list;
    }

    public void helper(int n, String s, int left, int right, List<String> list) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }

        if (left > 0) {
            s += "(";
            if (check(s)) {
                helper(n, s, left - 1, right, list);
            }
            s = s.substring(0, s.length() - 1);
        }
        if (right > 0) {
            s += ")";
            System.out.println(s);
            if (check(s)) {
                helper(n, s, left, right - 1, list);
            }
            s = s.substring(0, s.length() - 1);
        }
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        return stack.pop() == '(';
    }

    public List<String> generateParenthesis(int n) {
        List<String> rst = new LinkedList<>();
        backtrace(rst, "", n, 0, 0);
        return rst;
    }

    public void backtrace(List<String> rst, String s, int n, int left, int right) {
        if (s.length() == n * 2) {
            rst.add(s);
            return;
        }
        if (left < n) {
            backtrace(rst, s + "(", n, left + 1, right);
        }
        if (right < left) {
            backtrace(rst, s + ")", n, left, right + 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        GenerateParentheses solu = new GenerateParentheses();
        System.out.println(solu.generateParenthesis(3));
    }
}
