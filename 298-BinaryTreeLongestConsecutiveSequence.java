package LeetCode;

/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node
in the tree along the parent-child connections.
The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    /
   2
  /
 1

Output: 2

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */

public class BinaryTreeLongestConsecutiveSequence {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rst = search(root, 1);
        rst = Math.max(rst, longestConsecutive(root.left));
        rst = Math.max(rst, longestConsecutive(root.right));

        return rst;
    }

    public int search(TreeNode root, int cur) {
        if (root == null) {
            return cur;
        }

        int rst = cur;
        if (root.left != null) {
            if (root.left.val - root.val == 1) {
                rst = Math.max(rst, search(root.left, cur + 1));
            }
        }

        if (root.right != null) {
            if (root.right.val - root.val == 1) {
                rst = Math.max(rst, search(root.right, cur + 1));
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(3);
        n.right.left = new TreeNode(2);
        n.right.right = new TreeNode(4);
        n.right.right.right = new TreeNode(5);

        BinaryTreeLongestConsecutiveSequence solu = new BinaryTreeLongestConsecutiveSequence();
        System.out.println(solu.longestConsecutive(n));
    }

    public static void testcase2() {
        TreeNode n = new TreeNode(2);
        n.right = new TreeNode(3);
        n.right.left = new TreeNode(2);
        n.right.left.left = new TreeNode(1);

        BinaryTreeLongestConsecutiveSequence solu = new BinaryTreeLongestConsecutiveSequence();
        System.out.println(solu.longestConsecutive(n));
    }
}
