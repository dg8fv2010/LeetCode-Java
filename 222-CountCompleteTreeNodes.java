package LeetCode;

/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 */

public class CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        int hl = 0;
        int hr = 0;
        TreeNode cur = root;
        while (cur != null) {
            hl++;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            hr++;
            cur = cur.right;
        }
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes1(TreeNode root) {
        return root == null ? 0 : (1 + countNodes(root.left) + countNodes(root.right));
    }
}
