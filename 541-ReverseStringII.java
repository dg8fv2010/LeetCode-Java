package LeetCode;

/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */

public class ReverseStringII {
    // 当s的长度小于2k大于k的时候，这些都要reverse
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int idx = 0;
        while (idx < s.length()) {
            if (idx + k - 1 < s.length()) {
                swap_str(arr, idx, idx + k - 1);
            } else {
                swap_str(arr, idx, s.length() - 1);
            }
            idx += 2 * k;
        }

        return new String(arr);
    }

    public void swap_str(char[] arr, int l, int r) {
        while (l <= r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ReverseStringII solu = new ReverseStringII();
        System.out.println(solu.reverseStr("abcdefg", 8));
        System.out.println(solu.reverseStr("abcdef", 3));
        System.out.println(solu.reverseStr("abcdefg", 2));
    }
}
