package LeetCode;

/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */


import javafx.scene.transform.Shear;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void postorder(TreeNode root, List<Integer> rst) {
        if (root == null) return;
        postorder(root.left, rst);
        postorder(root.right, rst);
        rst.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        this.postorder(root, rst);
        return rst;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) return rst;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            rst.add(0, n.val);
            if (n.left != null) s.push(n.left);
            if (n.right != null) s.push(n.right);
        }
        return rst;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) return rst;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode head = root;
        while (!s.isEmpty()) {
            TreeNode t = s.peek();
            if ((t.left == null && t.right == null) || t.left == head || t.right == head) {
                rst.add(t.val);
                head = t;
                s.pop();
            } else {
                if (t.right != null) s.push(t.right);
                if (t.left != null) s.push(t.left);
            }
        }
        return rst;
    }

    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) return rst;
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p);
                rst.add(0, p.val);
                p = p.right;
            } else {
                TreeNode t = s.pop();
                p = t.left;
            }
        }
        return rst;
    }

    public void reverse(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode x = from;
        TreeNode y = from.right;
        while (true) {
            TreeNode tmp = y.right;
            y.right = x;
            x = y;
            y = tmp;
            if (x == to) {
                break;
            }
        }
    }

    public void reversefunc(TreeNode from, TreeNode to, List<Integer> rst) {
        this.reverse(from, to);
        TreeNode p = to;
        while (true) {
            rst.add(p.val);
            if (p == from) break;
            p = p.right;
        }
        this.reverse(to, from);
    }

    // https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    // https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) return rst;
        TreeNode dump = new TreeNode(-1);
        dump.left = root;
        TreeNode cur = dump;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    this.reversefunc(cur.left, pre, rst);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return rst;
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(6);
        BinaryTreePostorderTraversal solu = new BinaryTreePostorderTraversal();
        System.out.println(solu.postorderTraversal(n));
    }

    public static void testcase2() {
        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);
        BinaryTreePostorderTraversal solu = new BinaryTreePostorderTraversal();
        System.out.println(solu.postorderTraversal(n));
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }
}
