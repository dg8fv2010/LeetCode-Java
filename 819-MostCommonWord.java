package LeetCode;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        int idx = 0;
        int cnt = 0;
        String rst = "";
        while (idx < paragraph.length()) {
            if (!Character.isLetter(paragraph.charAt(idx))) {
                idx++;
                continue;
            }
            StringBuilder tmp = new StringBuilder();
            while (idx < paragraph.length() && Character.isLetter(paragraph.charAt(idx))) {
                tmp.append(Character.toLowerCase(paragraph.charAt(idx)));
                idx++;
            }

            if (set.contains(tmp.toString())) {
                continue;
            }
            map.put(tmp.toString(), map.getOrDefault(tmp.toString(), 0) + 1);
            if (map.get(tmp.toString()) > cnt) {
                cnt = map.get(tmp.toString());
                rst = tmp.toString();
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MostCommonWord solu = new MostCommonWord();
        System.out.println(solu.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
