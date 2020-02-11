package LeetCode;

/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]


Note: For the return value, each inner list's elements must follow the lexicographic order.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    // 字符串中，相邻两个字母的差做为key
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String diff = "";
            if (str.length() <= 1) {
                diff = "0#";
            } else {
                int idx = 1;
                while (idx < str.length()) {
                    int dis = str.charAt(idx) - str.charAt(idx - 1);
                    dis = dis < 0 ? dis + 26 : dis;
                    String tmp = dis + "#";
                    diff += tmp;
                    idx++;
                }
            }

            if (!map.containsKey(diff)) {
                map.put(diff, new LinkedList<>());
            }
            map.get(diff).add(str);
        }

        List<List<String>> rst = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry:map.entrySet()) {
            rst.add(entry.getValue());
        }
        return rst;
    }

    public static void testcase3() {
        String[] a = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        GroupShiftedStrings solu = new GroupShiftedStrings();
        System.out.println(solu.groupStrings(a));
    }

    public static void main(String[] args) {
        testcase3();
    }
}
