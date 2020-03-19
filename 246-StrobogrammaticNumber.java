package LeetCode;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false
 */

import java.util.HashMap;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic1(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        StringBuilder rst = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            rst.append(map.get(c));
        }
        return num.equals(rst.reverse().toString());
    }

    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            if (num.charAt(l) == num.charAt(r)) {
                if (num.charAt(l) != '0' && num.charAt(l) != '1' && num.charAt(l) != '8') {
                    return false;
                }
            } else {
                if ((num.charAt(l) != '6' || num.charAt(r) != '9') && (num.charAt(l) != '9' || num.charAt(r) != '6')) {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        StrobogrammaticNumber solu = new StrobogrammaticNumber();
        System.out.println(solu.isStrobogrammatic("69"));
        System.out.println(solu.isStrobogrammatic("88"));
        System.out.println(solu.isStrobogrammatic("692"));
    }
}
