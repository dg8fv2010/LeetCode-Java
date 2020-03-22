package LeetCode;

/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.


Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.


Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.
 */

public class StringCompression {
    public int compress(char[] chars) {
        int rst = 0;
        int idx = 0;
        while (idx < chars.length) {
            int cnt = 1;
            while (idx + 1 < chars.length && chars[idx] == chars[idx + 1]) {
                idx++;
                cnt++;
            }
            chars[rst++] = chars[idx];

            if (cnt > 1) {
                int div = 1;
                while (cnt / div >= 10) {
                    div *= 10;
                }
                while (cnt >= 0 && div > 0) {
                    int num = cnt / div;
                    chars[rst++] = (char) (num + '0');
                    cnt -= num * div;
                    div /= 10;
                }
            }
            idx++;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        StringCompression solu = new StringCompression();
        System.out.println(solu.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(solu.compress(new char[]{'a'}));
        System.out.println(solu.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(solu.compress(new char[]{'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'}));
    }
}
