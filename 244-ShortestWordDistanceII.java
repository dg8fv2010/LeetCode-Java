package LeetCode;

/*
Design a class which receives a list of words in the constructor,
and implements a method that takes two words word1 and word2 and
return the shortest distance between these two words in the list.
Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestWordDistanceII {

    private HashMap<String, ArrayList<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!this.map.containsKey(words[i])) {
                this.map.put(words[i], new ArrayList<>());
            }
            this.map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> aa = this.map.get(word1);
        ArrayList<Integer> bb = this.map.get(word2);
        int rst = Integer.MAX_VALUE;
        ;
        int i = 0;
        int j = 0;
        while (i < aa.size() && j < bb.size()) {
            rst = Math.min(rst, Math.abs(aa.get(i) - bb.get(j)));
            if (aa.get(i) < bb.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return rst;
    }

    public int shortest1(String word1, String word2) {
        ArrayList<Integer> aa = this.map.get(word1);
        ArrayList<Integer> bb = this.map.get(word2);
        int rst = Integer.MAX_VALUE;
        for (int a : aa) {
            for (int b : bb) {
                rst = Math.min(rst, Math.abs(a - b));
            }
        }
        return rst;
    }
}
