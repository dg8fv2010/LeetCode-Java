package LeetCode;

/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to
any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */

public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int rst;

    public int maxPathSum(TreeNode root) {
        this.rst = Integer.MIN_VALUE;
        dfs(root);
        return this.rst;
    }

    public int dfs(TreeNode root) {
        int left = root.left == null ? 0 : Math.max(0, dfs(root.left));
        int right = root.right == null ? 0 : Math.max(0, dfs(root.right));
        int cur = root.val + left + right;
        this.rst = Math.max(this.rst, cur);
        return root.val + Math.max(left, right);
    }
}
