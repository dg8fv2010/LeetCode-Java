package LeetCode;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }

        for (int i=0;i<s.length();i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
