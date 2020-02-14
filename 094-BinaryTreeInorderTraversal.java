package LeetCode;


/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void dfs(TreeNode root, List<Integer> rst) {
        if (root == null) return;
        dfs(root.left, rst);
        rst.add(root.val);
        dfs(root.right, rst);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        dfs(root, rst);
        return rst;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            rst.add(curr.val);
            curr = curr.right;
        }
        return rst;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode q = root;
        while (!s.isEmpty() || q != null) {
            if (q != null) {
                s.push(q);
                q = q.left;
            } else {
                TreeNode t = s.pop();
                rst.add(t.val);
                q = t.right;
            }
        }
        return rst;
    }

    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left == null) {
                rst.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur;
                TreeNode tmp = cur;
                cur = cur.left;
                tmp.left = null;
            }
        }
        return rst;
    }

    // https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    rst.add(cur.val);
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
        BinaryTreeInorderTraversal solu = new BinaryTreeInorderTraversal();
        System.out.println(solu.inorderTraversal(n));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
