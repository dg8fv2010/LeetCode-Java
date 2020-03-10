package LeetCode;

/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        Deque<TreeNode> p_que = new ArrayDeque<>();
        Deque<TreeNode> q_que = new ArrayDeque<>();
        p_que.offerLast(p);
        q_que.offerLast(q);

        while (!p_que.isEmpty()) {
            TreeNode pn = p_que.removeFirst();
            TreeNode qn = q_que.removeFirst();

            if (!check(pn, qn)) return false;
            if (!check(pn.left, qn.left)) return false;
            if (pn.left != null) {
                p_que.offerLast(pn.left);
                q_que.offerLast(qn.left);
            }

            if (!check(pn.right, qn.right)) return false;
            if (pn.right != null) {
                p_que.offerLast(pn.right);
                q_que.offerLast(qn.right);
            }
        }
        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val;
    }

    public static void main(String[] args) {
        testcase3();
    }

    public static void testcase1() {
        SameTree solu = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        solu.isSameTree(p, q);
    }

    public static void testcase2() {
        SameTree solu = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        solu.isSameTree(p, q);
    }

    public static void testcase3() {
        SameTree solu = new SameTree();
        solu.isSameTree(null, null);
    }
}
