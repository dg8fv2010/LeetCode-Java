package LeetCode;

/*
From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

Example 1:

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
Example 2:

Input: source = "abc", target = "acdbc"
Output: -1
Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
Example 3:

Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
Constraints:

Both the source and target strings consist of only lowercase English letters from "a"-"z".
The lengths of source and target string are between 1 and 1000.
 */

import java.util.HashMap;
import java.util.TreeSet;

public class ShortestWaytoFormString {
    public int shortestWay(String source, String target) {
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            TreeSet<Integer> set = map.getOrDefault(source.charAt(i), new TreeSet<>());
            set.add(i);
            map.put(source.charAt(i), set);
        }

        int rst = 0;
        int prev = -1;
        int idx = 0;
        while (idx < target.length()) {
            TreeSet<Integer> set = map.get(target.charAt(idx));
            if (set == null) {
                return -1;
            }
            Integer cur = set.higher(prev);
            if (cur != null) {
                prev = cur;
            } else {
                rst++;
                prev = set.first();
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ShortestWaytoFormString solu = new ShortestWaytoFormString();
        System.out.println(solu.shortestWay("xxyz", "xxzyxz"));
    }
}
