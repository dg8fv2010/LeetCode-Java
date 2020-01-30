package LeetCode;

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int rst = -1;
        int idx_a = 0;
        // 不需要遍历整个字符串，如果haystack剩下的长度小于needle的长度，就可以结束了
        while (haystack.length() - idx_a >= needle.length()) {
            if (haystack.charAt(idx_a) == needle.charAt(0)) {
                int idx_b = 0;
                while (idx_b < needle.length()) {
                    if (haystack.charAt(idx_a + idx_b) != needle.charAt(idx_b)) {
                        break;
                    } else {
                        idx_b++;
                    }
                }

                if (idx_b == needle.length()) {
                    rst = idx_a;
                    break;
                }
            }
            idx_a++;
        }
        return rst;
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        ImplementstrStr solu = new ImplementstrStr();
        System.out.println("1:" + solu.strStr("mississippi", "issipi"));
        System.out.println("1:" + solu.strStr("a", "a"));
        System.out.println("1:" + solu.strStr("hello", "ll"));
        System.out.println("1:" + solu.strStr("aaaaa", "bba"));
    }
}
