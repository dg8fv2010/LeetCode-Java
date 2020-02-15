package LeetCode;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) return rst;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                l.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            rst.add(l);
        }
        return rst;
    }

    public void travel(TreeNode root, int level, List<List<Integer>> rst) {
        if (root == null) return;
        if (level == rst.size()) {
            rst.add(new LinkedList<>());
        }
        rst.get(level).add(root.val);
        if (root.left != null) travel(root.left, level + 1, rst);
        if (root.right != null) travel(root.right, level + 1, rst);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) return rst;
        this.travel(root, 0, rst);
        return rst;
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(6);
        BinaryTreeLevelOrderTraversal solu = new BinaryTreeLevelOrderTraversal();
        System.out.println(solu.levelOrder(n));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
