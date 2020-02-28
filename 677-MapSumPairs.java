package LeetCode;

/*
Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */

import java.util.HashMap;

public class MapSumPairs {
    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MapSumPairs solu = new MapSumPairs();
        solu.insert("apple", 3);
        System.out.println(solu.sum("ap"));
        solu.insert("app", 2);
        System.out.println(solu.sum("ap"));
    }
}

class MapSumPairs1 {
    HashMap<String, Integer> map;
    HashMap<String, Integer> score;

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs1() {
        this.map = new HashMap<>();
        this.score = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - this.map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for (char c : key.toCharArray()) {
            prefix += c;
            this.score.put(prefix, this.score.getOrDefault(prefix, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return this.score.getOrDefault(prefix, 0);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MapSumPairs solu = new MapSumPairs();
        solu.insert("apple", 3);
        System.out.println(solu.sum("ap"));
        solu.insert("app", 2);
        System.out.println(solu.sum("ap"));
    }
}

class MapSumPairs2 {
    public static class TrieNode {
        HashMap<Character, TrieNode> children;
        int score;

        public TrieNode() {
            this.children = new HashMap<>();
            this.score = 0;
        }
    }

    TrieNode root;
    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs2() {
        this.root = new TrieNode();
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - this.map.getOrDefault(key, 0);
        TrieNode cur = this.root;
        cur.score += delta;
        map.put(key, val);
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = this.root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MapSumPairs solu = new MapSumPairs();
        solu.insert("apple", 3);
        System.out.println(solu.sum("ap"));
        solu.insert("app", 2);
        System.out.println(solu.sum("ap"));
    }
}