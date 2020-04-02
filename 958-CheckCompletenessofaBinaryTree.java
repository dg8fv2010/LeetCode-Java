package LeetCode;

/*
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.



Example 1:



Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:



Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.

Note:

The tree will have between 1 and 100 nodes.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur == null) {
                break;
            }
            que.add(cur.left);
            que.add(cur.right);
        }

        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testcase2();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(6);
        CheckCompletenessofaBinaryTree solu = new CheckCompletenessofaBinaryTree();
        System.out.println(solu.isCompleteTree(n));
    }

    public static void testcase2() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.left.left.left = new TreeNode(6);
        CheckCompletenessofaBinaryTree solu = new CheckCompletenessofaBinaryTree();
        System.out.println(solu.isCompleteTree(n));
    }

}
