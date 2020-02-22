package LeetCode;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */

import java.util.LinkedList;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void inorder(TreeNode root, LinkedList<Integer> val) {
        if (root == null) return;
        inorder(root.left, val);
        val.add(root.val);
        inorder(root.right, val);

    }

    public boolean isValidBST1(TreeNode root) {
        LinkedList<Integer> val = new LinkedList<>();
        this.inorder(root, val);
        for (int i = 0; i < val.size() - 1; i++) {
            if (val.get(i) >= val.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        int val = root.val;
        if (low != null && val <= low) return false;
        if (high != null && val >= high) return false;

        if (!helper(root.left, low, val)) return false;
        if (!helper(root.right, val, high)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return this.helper(root, null, null);
    }

    public boolean isValidBST3(TreeNode root) {
        Stack<Integer> lows = new Stack<>();
        Stack<Integer> highs = new Stack<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        lows.push(null);
        highs.push(null);

        while (!nodes.isEmpty()) {
            Integer low = lows.pop();
            Integer high = highs.pop();
            TreeNode n = nodes.pop();

            if (n == null) continue;
            int val = n.val;
            if (low != null && val <= low) return false;
            if (high != null && val >= high) return false;
            nodes.push(n.right);
            lows.push(val);
            highs.push(high);
            nodes.push(n.left);
            lows.push(low);
            highs.push(val);
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        double prev = -Double.MAX_VALUE;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prev >= cur.val) return false;
            prev = cur.val;
            cur = cur.right;
        }
        return true;
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(5);
        n.right = new TreeNode(15);
        n.right.left = new TreeNode(6);
        n.right.right = new TreeNode(20);
        ValidateBinarySearchTree solu = new ValidateBinarySearchTree();
        System.out.println(solu.isValidBST(n));
    }

    public static void testcase2() {
        TreeNode n = new TreeNode(2);
        n.left = new TreeNode(1);
        n.right = new TreeNode(3);
        ValidateBinarySearchTree solu = new ValidateBinarySearchTree();
        System.out.println(solu.isValidBST(n));
    }

    public static void main(String[] args) {
        testcase2();
    }

}
