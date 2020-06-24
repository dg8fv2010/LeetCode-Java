package LeetCode;

/*
Given a list of words and two words word1 and word2,
return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
 */

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int a = -1;
        int b = -1;
        int rst = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i]) && i != b) {
                a = i;
            }
            if (word2.equals(words[i]) && i != a) {
                b = i;
            }
            if (a != -1 && b != -1) {
                rst = Math.min(rst, Math.abs(a - b));
            }
        }
        return rst;
    }
}
