package LeetCode;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) return "";
        StringBuilder rst = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n != null) {
                rst.append(n.val).append(",");
                q.add(n.left);
                q.add(n.right);
            } else {
                rst.append("null,");
            }
        }

        String tmp = rst.substring(0, rst.length() - 1);
        return tmp + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data == null || data.length() == 0) return null;
        String content = data.substring(1, data.length() - 1);
        String[] node = content.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        q.add(root);
        int idx = 1;
        while (idx < node.length) {
            TreeNode n = q.poll();
            if (!node[idx].equals("null")) {
                n.left = new TreeNode(Integer.parseInt(node[idx]));
                q.add(n.left);
            }
            idx++;
            if (!node[idx].equals("null")) {
                n.right = new TreeNode(Integer.parseInt(node[idx]));
                q.add(n.right);
            }
            idx++;
        }
        return root;
    }

    // preorder实现
    public String serialize(TreeNode root) {
        StringBuilder rst = new StringBuilder();
        rst.append("[");
        this.dfs(root, rst);
        String tmp = rst.substring(0, rst.length() - 1);
        return tmp + "]";
    }

    public void dfs(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
        } else {
            str.append(root.val).append(",");
            dfs(root.left, str);
            dfs(root.right, str);
        }
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.substring(1, data.length() - 1).split(",");
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(strs));
        return this.dfs2(queue);
    }

    public TreeNode dfs2(LinkedList<String> queue) {
        String data = queue.pollFirst();
        if (data.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data));
        root.left = dfs2(queue);
        root.right = dfs2(queue);
        return root;
    }

    public static void testcase() {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.right.left = new TreeNode(4);
        r.right.right = new TreeNode(5);

        SerializeandDeserializeBinaryTree solu = new SerializeandDeserializeBinaryTree();
        // System.out.println(solu.serialize(r));
        solu.deserialize(solu.serialize(r));
    }

    public static void main(String[] args) {
        testcase();
    }
}
