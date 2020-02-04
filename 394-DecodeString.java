package LeetCode;

/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

import java.util.Stack;

public class DecodeString {
    private String decode(String s) {
        String rst = "";
        while (this.idx < s.length() && s.charAt(this.idx) != ']') {
            if (Character.isDigit(s.charAt(this.idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(this.idx))) {
                    count = count * 10 + (s.charAt(this.idx) - '0');
                    this.idx++;
                }
                this.idx++;
                String tmp = decode(s);
                this.idx++;

                while (count > 0) {
                    count--;
                    rst += tmp;
                }
            } else {
                rst += s.charAt(this.idx);
                this.idx++;
            }
        }
        return rst;
    }

    private int idx;

    String decodeString1(String s) {
        this.idx = 0;
        return decode(s);
    }

    public String decodeString(String s) {
        String rst = "";
        Stack<Integer> s_num = new Stack<>();
        Stack<String> s_str = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                cnt = cnt * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                s_num.push(cnt);
                s_str.push(rst);
                cnt = 0;
                rst = "";
            } else if (s.charAt(i) == ']') {
                int k = s_num.pop();
                String tmp = "";
                for (int j = 0; j < k; j++) {
                    tmp += rst;
                }
                rst = s_str.pop() + tmp;
            } else {
                rst += s.charAt(i);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        DecodeString solu = new DecodeString();
        System.out.println("1:" + solu.decodeString("3[a]2[bc]"));
        System.out.println("1:" + solu.decodeString("3[a2[c]]"));
        System.out.println("1:" + solu.decodeString("2[abc]3[cd]ef"));
    }
}
