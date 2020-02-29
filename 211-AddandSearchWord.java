package LeetCode;

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */

public class AddandSearchWord {
    public static class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddandSearchWord() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode cur = this.root;
        return this.search_helper(cur, word, 0);
    }

    public boolean search_helper(TrieNode root, String word, int idx) {
        if (idx == word.length()) return root.isEnd();
        if (word.charAt(idx) == '.') {
            for (int j = 0; j < 26; j++) {
                if (root.children[j] != null && search_helper(root.children[j], word, idx + 1)) return true;
            }
            return false;
        } else {
            TrieNode child = root.children[word.charAt(idx) - 'a'];
            return child != null && search_helper(child, word, idx + 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        AddandSearchWord solu = new AddandSearchWord();
        solu.addWord("bad");
        solu.addWord("dad");
        solu.addWord("mad");
        System.out.println(solu.search("pad")); // -> false
        System.out.println(solu.search("bad")); // -> true
        System.out.println(solu.search(".ad")); // -> true
        System.out.println(solu.search("b..")); // -> true
    }

    public static void testcase2() {
        AddandSearchWord solu = new AddandSearchWord();
        solu.addWord("at");
        solu.addWord("and");
        solu.addWord("an");
        solu.addWord("add");
        System.out.println(solu.search("pad")); // -> false
        System.out.println(solu.search("bad")); // -> true
        System.out.println(solu.search(".ad")); // -> true
        System.out.println(solu.search("b..")); // -> true
    }
}
