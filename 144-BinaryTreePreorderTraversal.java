package LeetCode;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void preorder(TreeNode root, List<Integer> rst) {
        if (root == null) return;
        rst.add(root.val);
        preorder(root.left, rst);
        preorder(root.right, rst);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        this.preorder(root, rst);
        return rst;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) return rst;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            rst.add(n.val);
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);
        }
        return rst;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode q = root;
        while (!s.isEmpty() || q != null) {
            if (q != null) {
                s.push(q);
                rst.add(q.val);
                q = q.left;
            } else {
                TreeNode t = s.pop();
                q = t.right;
            }
        }
        return rst;
    }

    // https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                rst.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    rst.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return rst;
    }
}
