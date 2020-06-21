package LeetCode;

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of this node's descendants.
The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeofAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 慢
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(s);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.val == t.val) {
                if (check(cur, t)) {
                    return true;
                }
            }
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
        return false;
    }

    // 快
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (check(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

}
