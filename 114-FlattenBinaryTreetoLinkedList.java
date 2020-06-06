package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */

public class FlattenBinaryTreetoLinkedList {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }

    public void flatten1(TreeNode root) {
        List<TreeNode> l = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                l.add(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                cur = cur.right;
            }
        }

        TreeNode dummy = new TreeNode(-1);
        cur = dummy;

        for (TreeNode n : l) {
            cur.right = n;
            cur = cur.right;
            cur.left = null;
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(5);
        n.left.left = new TreeNode(3);
        n.left.right = new TreeNode(4);
        n.right.right = new TreeNode(6);

        FlattenBinaryTreetoLinkedList solu = new FlattenBinaryTreetoLinkedList();
        solu.flatten(n);
    }

}
