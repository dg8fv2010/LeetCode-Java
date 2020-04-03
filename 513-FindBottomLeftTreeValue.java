package LeetCode;

/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
 */

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int rst = root.val;
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (i == 0) {
                    rst = cur.val;
                }
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
        }
        return rst;
    }
}
