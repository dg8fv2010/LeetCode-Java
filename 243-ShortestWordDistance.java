package LeetCode;

/*
Given a list of words and two words word1 and word2,
return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int rst = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                a = i;
            }
            if (word2.equals(words[i])) {
                b = i;
            }
            if (a != -1 && b != -1) {
                rst = Math.min(rst, Math.abs(a - b));
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ShortestWordDistance solu = new ShortestWordDistance();
        System.out.println(solu.shortestDistance(new String[]{
                        "practice", "makes", "perfect", "coding", "makes"},
                "coding", "practice"));
        System.out.println(solu.shortestDistance(new String[]{
                        "practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding"));
    }
}

