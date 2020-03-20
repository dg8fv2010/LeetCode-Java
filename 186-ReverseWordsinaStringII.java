package LeetCode;

/*
Given an input string , reverse the string word by word.

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note:

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */

public class ReverseWordsinaStringII {
    // 先把整个数组reverse
    // 再遍历数组，发现空格就reverse
    public void reverseWords(char[] s) {
        int l = 0;
        int r = s.length - 1;
        swap_arr(s, l, r);


        l = 0;
        r = 0;
        while (r <= s.length) {
            if (r == s.length) {
                swap_arr(s, l, r - 1);
                break;
            } else if (s[r] == ' ') {
                swap_arr(s, l, r - 1);
                l = r + 1;
            }
            r++;
        }
    }

    public void swap_arr(char[] s, int l, int r) {
        while (l <= r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ReverseWordsinaStringII solu = new ReverseWordsinaStringII();
        char[] a = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        solu.reverseWords(a);
    }
}
