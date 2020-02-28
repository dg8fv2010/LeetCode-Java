package LeetCode;

/*
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"


Note:

The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReplaceWords {
    public static class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String str : dict) {
            this.buildTree(root, str);
        }

        String[] strs = sentence.split(" ");
        String rst = "";
        for (String str : strs) {
            rst += this.search(root, str) + " ";
        }
        return rst.substring(0, rst.length() - 1);
    }

    public void buildTree(TrieNode root, String str) {
        TrieNode cur = root;
        for (char c : str.toCharArray()) {
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.setEnd();
    }

    public String search(TrieNode root, String str) {
        TrieNode cur = root;
        String rst = "";
        for (char c : str.toCharArray()) {
            if (cur.children.get(c) != null) {
                cur = cur.children.get(c);
                rst += c;
                if (cur.isEnd()) {
                    break;
                }
            } else {
                rst = str;
                break;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1(){
        ReplaceWords solu = new ReplaceWords();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(solu.replaceWords(dict, sentence));
    }
}
