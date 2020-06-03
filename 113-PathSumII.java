package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class PathSumII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        search(root, sum, cur, rst);
        return rst;
    }

    public void search(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> rst) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                rst.add(new ArrayList<>(cur));
            }
            cur.remove(cur.size() - 1);
            return;
        }
        if (root.left != null) {
            search(root.left, sum - root.val, cur, rst);
        }
        if (root.right != null) {
            search(root.right, sum - root.val, cur, rst);
        }

        cur.remove(cur.size() - 1);
    }
}
