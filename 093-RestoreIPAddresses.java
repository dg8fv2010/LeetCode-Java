package LeetCode;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new LinkedList<>();
        dfs(rst, s, 1, "");
        return rst;
    }

    public void dfs(List<String> rst, String s, int cnt, String cur) {
        if (cnt == 4) {
            if (s.length() > 4) {
                return;
            }
            if (s.length() > 1 && s.charAt(0) == '0') {
                return;
            }
            int num = Integer.parseInt(s);
            if (num > 255) {
                return;
            }
            cur += "." + s;
            rst.add(cur);
            return;
        }
        for (int i = 1; i < s.length() && i < 4; i++) {
            String sub = s.substring(0, i);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                continue;
            }
            int num = Integer.parseInt(sub);
            if (num > 255) {
                continue;
            }
            dfs(rst, s.substring(i), cnt + 1, cur + (cur.length() == 0 ? "" : ".") + sub);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        RestoreIPAddresses solu = new RestoreIPAddresses();
        System.out.println(solu.restoreIpAddresses("25525511135"));
        System.out.println(solu.restoreIpAddresses("010010"));
    }
}
