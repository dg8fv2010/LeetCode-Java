package LeetCode;

/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

public class ClosestBinarySearchTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue1(TreeNode root, double target) {
        int rst = Integer.MAX_VALUE;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(target - cur.val) < Math.abs(target - rst)) {
                rst = cur.val;
            }

            if (cur.val > target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return rst;
    }

    int ans;

    public int closestValue(TreeNode root, double target) {
        this.ans = Integer.MAX_VALUE;
        helper(root, target);
        return this.ans;
    }

    public void helper(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(target - root.val) < Math.abs(target - this.ans)) {
            this.ans = root.val;
        }
        if (root.val > target) helper(root.left, target);
        else helper(root.right, target);
    }
}
