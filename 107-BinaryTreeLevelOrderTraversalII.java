package LeetCode;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        dfs(rst, root, 0);
        Collections.reverse(rst);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (rst.size() == level) {
            rst.add(new LinkedList<>());
        }
        rst.get(level).add(root.val);
        dfs(rst, root.left, level + 1);
        dfs(rst, root.right, level + 1);
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                l.add(cur.val);
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
            rst.add(l);
        }
        Collections.reverse(rst);
        return rst;
    }
}
