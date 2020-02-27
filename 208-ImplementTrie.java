package LeetCode;

/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

public class ImplementTrie {
    public static class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containsKey(Character ch) {
            return this.links[ch - 'a'] == null;
        }

        public TrieNode get(Character ch) {
            return this.links[ch - 'a'];
        }

        public void put(Character ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public ImplementTrie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.get(word.charAt(i)) == null) {
                cur.put(word.charAt(i), new TrieNode());
            }
            cur = cur.get(word.charAt(i));
        }
        cur.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.get(word.charAt(i)) == null) return false;
            cur = cur.get(word.charAt(i));
        }
        return cur.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.get(prefix.charAt(i)) == null) return false;
            cur = cur.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ImplementTrie trie = new ImplementTrie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

}
