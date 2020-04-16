package LeetCode;

/*
Given a set of string which has just lower case letters and a target string,
output all the strings for each the edit distance with the target no greater than k.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example

Given words = ["abc", "abd", "abcd", "adc"] and target = "ac", k = 1
Return ["abc", "adc"]

 */

import java.util.LinkedList;
import java.util.List;

public class LintCodeKEditDistance {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = "";
        }
    }

    public List<String> kDistance(String[] words, String targets, int k) {
        List<String> rst = new LinkedList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            create_tree(root, word);
        }

        int[] dp = new int[targets.length() + 1];
        for (int i = 0; i <= targets.length(); i++) {
            dp[i] = i;
        }

        dfs(rst, root, dp, targets, k);

        return rst;
    }

    public void create_tree(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }

    public void dfs(List<String> rst, TrieNode root, int[] dp, String target, int k) {
        int n = target.length();
        if (root.word.length() > 0) {
            if (dp[n] <= k) {
                rst.add(root.word);
            }
        }

        int[] new_dp = new int[n + 1];
        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) {
                continue;
            }
            new_dp[0] = dp[0] + 1;
            for (int j = 1; j <= n; j++) {
                new_dp[j] = Math.min(dp[j] + 1, Math.min(new_dp[j - 1] + 1, dp[j - 1] + 1));
                int cur_c = target.charAt(j - 1) - 'a';
                if (cur_c == i) {
                    new_dp[i] = Math.min(new_dp[j], dp[j - 1]);
                }
            }
            dfs(rst, root.children[i], new_dp, target, k);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeKEditDistance solu = new LintCodeKEditDistance();
        System.out.println(solu.kDistance(new String[]{"abc", "abd", "abcd", "adc"}, "ac", 1));
    }
}
