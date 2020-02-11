package LeetCode;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */

import java.util.*;

public class GroupAnagrams {
    // 先对string排序生成key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(strs[i]);
        }

        List<List<String>> rst = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            rst.add(entry.getValue());
        }
        return rst;
    }

    public static void testcase3() {
        String[] a = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams solu = new GroupAnagrams();
        System.out.println(solu.groupAnagrams(a));
    }

    public static void main(String[] args) {
        testcase3();
    }
}
