package LeetCode;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.



Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false


Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */

import java.util.Stack;

public class BinarySearchTreeIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack;

    public void helper(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.helper(root);
    }

    /**
     * @return the next smallest number
     */
    // helper不是每次都运行
    // 所以时间复杂度还是O(1)
    public int next() {
        TreeNode n = this.stack.pop();
        if (n.right != null) {
            this.helper(n.right);
        }
        return n.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size() > 0;
    }
}
