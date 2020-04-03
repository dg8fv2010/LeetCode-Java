package LeetCode;

/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        HashSet<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add(S);
        set.add(S);
        while (!que.isEmpty()) {
            StringBuilder sb = new StringBuilder(que.poll());
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (Character.isLetter(c)) {
                    if (Character.isLowerCase(c)) {
                        sb.setCharAt(i, Character.toUpperCase(c));
                    } else if (Character.isUpperCase(c)) {
                        sb.setCharAt(i, Character.toLowerCase(c));
                    }
                    String tmp = sb.toString();
                    if (!set.contains(tmp)) {
                        set.add(tmp);
                        que.add(tmp);
                    }
                }
                sb.setCharAt(i, c);
            }
        }
        return new LinkedList<>(set);
    }
}
