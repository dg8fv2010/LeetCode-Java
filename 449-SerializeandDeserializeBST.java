package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that
it can be stored in a file or memory buffer, or transmitted across a network connection link to be
reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary search tree can be serialized to a string and this string can be
deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states.
Your serialize and deserialize algorithms should be stateless.
 */

public class SerializeandDeserializeBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root, str);
        return str.substring(0, str.length() - 1);
    }

    public void dfs(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("N,");
        } else {
            str.append(root.val).append(",");
            dfs(root.left, str);
            dfs(root.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(q);
    }

    public TreeNode dfs2(Queue<String> q) {
        String s = q.poll();
        if (s.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = dfs2(q);
        root.right = dfs2(q);
        return root;

    }
}
