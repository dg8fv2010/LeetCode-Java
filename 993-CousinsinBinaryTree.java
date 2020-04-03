package LeetCode;

/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            TreeNode xp = null;
            TreeNode yp = null;
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur.left != null) {
                    que.add(cur.left);
                    if (cur.left.val == x) {
                        xp = cur;
                    }
                    if (cur.left.val == y) {
                        yp = cur;
                    }
                }
                if (cur.right != null) {
                    que.add(cur.right);
                    if (cur.right.val == x) {
                        xp = cur;
                    }
                    if (cur.right.val == y) {
                        yp = cur;
                    }
                }
            }

            if (xp != null && yp != null && xp != yp) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        CousinsinBinaryTree solu = new CousinsinBinaryTree();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        System.out.println(solu.isCousins(n, 3, 4));
    }
}
