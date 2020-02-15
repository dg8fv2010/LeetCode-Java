package LeetCode;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

import java.util.Stack;

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean func(TreeNode root, int sum) {
        if (root == null) return false;
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) return true;
        return func(root.left, sum) || func(root.right, sum);
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        return this.func(root, sum);
    }

    // 迭代，前序遍历，每次更新左右子节点的值，直到叶节点，判断叶节点的值是否等于sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            if (t.left == null && t.right == null && t.val == sum) return true;
            if (t.right != null) {
                t.right.val = t.right.val + t.val;
                s.push(t.right);
            }
            if (t.left != null) {
                t.left.val = t.left.val + t.val;
                s.push(t.left);
            }
        }
        return false;
    }
}
