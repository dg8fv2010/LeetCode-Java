package LeetCode;

/*
You need to find the largest value in each row of a binary tree.

Example:
Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        dfs(rst, root, 0);
        return rst;
    }

    public void dfs(List<Integer> rst, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (rst.size() == level) {
            rst.add(root.val);
        }
        rst.set(level, Math.max(rst.get(level), root.val));
        dfs(rst, root.left, level + 1);
        dfs(rst, root.right, level + 1);
    }

    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
            rst.add(max);
        }
        return rst;
    }
}
