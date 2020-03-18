package LeetCode;

/*
Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        if (m < n) {
            return isOneEditDistance(t, s);
        }

        if (m == n) {
            int idx = 0;
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    idx++;
                }
                if (idx > 1) {
                    return false;
                }
            }
            return true;
        }

        int idxs = 0;
        int idxt = 0;
        int cnt = 0;
        while (idxs < m && idxt < n) {
            if (s.charAt(idxs) != t.charAt(idxt)) {
                idxs++;
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
            idxs++;
            idxt++;
        }
        return true;
    }

    public static void main(String[] args) {
        OneEditDistance solu = new OneEditDistance();
        System.out.println(solu.isOneEditDistance("ab", "acb"));
        System.out.println(solu.isOneEditDistance("cab", "ad"));
        System.out.println(solu.isOneEditDistance("1203", "1213"));
        System.out.println(solu.isOneEditDistance("", "a"));
    }
}
