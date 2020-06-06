package LeetCode;

import java.util.Stack;

/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that
every key of the original BST is changed to the original key plus sum of all keys greater than
the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */

public class ConvertBSTtoGreaterTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 右节点->根结点->左节点
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        Integer val = null;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.right;
            } else {
                cur = st.pop();
                if (val == null) {
                    val = cur.val;
                } else {
                    int tmp = val;
                    val += cur.val;
                    cur.val += tmp;
                }
                cur = cur.left;
            }
        }
        return root;
    }
}
