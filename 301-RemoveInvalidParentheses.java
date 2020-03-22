package LeetCode;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 */

import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses {
    // 先统计出要删除的左右括号的数量
    //  再遍历字符串删除括号
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        List<String> rst = new LinkedList<>();
        dfs(rst, s, 0, l, r);
        return rst;
    }

    public void dfs(List<String> rst, String s, int start, int l, int r) {
        if (l == 0 && r == 0 && isValid(s)) {
            rst.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 如果出现相邻括号相同的情况，只需要处理第一个括号
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }

            if (s.charAt(i) == '(' && l > 0) {
                dfs(rst, s.substring(0, i) + s.substring(i + 1), i, l - 1, r);
            }
            if (s.charAt(i) == ')' && r > 0) {
                dfs(rst, s.substring(0, i) + s.substring(i + 1), i, l, r - 1);
            }
        }
    }

    public boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                if (cnt == 0) {
                    return false;
                } else {
                    cnt--;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        RemoveInvalidParentheses solu = new RemoveInvalidParentheses();
        System.out.println(solu.removeInvalidParentheses("()())()"));
        System.out.println(solu.removeInvalidParentheses("(a)())()"));
        System.out.println(solu.removeInvalidParentheses(")("));
    }
}
