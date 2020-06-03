package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        search(root, "", rst);
        return rst;
    }

    public void search(TreeNode root, String cur, List<String> rst) {
        if (root == null) {
            return;
        }


        String newS = "";
        if (cur.length() == 0) {
            newS = String.valueOf(root.val);
        } else {
            newS = cur + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            rst.add(newS);
            return;
        }

        if (root.left != null) {
            search(root.left, newS, rst);
        }
        if (root.right != null) {
            search(root.right, newS, rst);
        }

    }
}
