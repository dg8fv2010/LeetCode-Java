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
    public class TreeNode {
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


    public List<Integer> inorderTraversal(TreeNode root) {
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
}
