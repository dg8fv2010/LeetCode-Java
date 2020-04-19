package LeetCode;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.

Example:

Input: [10,5,15,1,8,null,7]

   10
   / \
  5  15
 / \   \
1   8   7

Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one.
             The return value is the subtree's size, which is 3.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 */

public class LargestBSTSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        if (root.left != null && root.left.val >= root.val) {
            return -1;
        }

        if (root.right != null && root.right.val <= root.val) {
            return -1;
        }

        return left + right + 1;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LargestBSTSubtree solu = new LargestBSTSubtree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        System.out.println(solu.largestBSTSubtree(root));
    }
}
