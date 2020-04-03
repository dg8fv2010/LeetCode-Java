package LeetCode;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int rst = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            rst++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur.left == null && cur.right == null) {
                    return rst;
                }
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
        }
        return 0;
    }

}
