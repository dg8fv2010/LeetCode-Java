package LeetCode;

/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:

Input: [1,2,3,4,5]

          1
         / \
        2   3
       / \
      4   5

Output: [[4,5,3],[2],[1]]


Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         /
        2


2. Now removing the leaf [2] would result in this tree:

          1


3. Now removing the leaf [1] would result in the empty tree:

          []
 */

import java.util.LinkedList;
import java.util.List;

public class FindLeavesofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        helper(root, rst);
        return rst;
    }

    public int helper(TreeNode root, List<List<Integer>> rst) {
        if (root == null) {
            return -1;
        }
        int depth = 1 + Math.max(helper(root.left, rst), helper(root.right, rst));
        if (depth >= rst.size()) {
            rst.add(new LinkedList<>());
        }
        rst.get(depth).add(root.val);
        return depth;
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        FindLeavesofBinaryTree solu = new FindLeavesofBinaryTree();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        System.out.println(solu.findLeaves(n));
    }
}
