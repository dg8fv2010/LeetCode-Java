package LeetCode;

/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 */

import java.util.*;

public class FindDuplicateSubtrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int t;
    Map<String, Integer> tree;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.t = 1;
        this.tree = new HashMap<>();
        this.count = new HashMap<>();
        this.ans = new LinkedList<>();
        this.func(root);
        return this.ans;
    }

    public int func(TreeNode root) {
        if (root == null) return 0;
        String str = root.val + "," + func(root.left) + "," + func(root.right);
        int uid = this.tree.computeIfAbsent(str, x -> t++);
        this.count.put(uid, this.count.getOrDefault(uid, 0) + 1);
        if (this.count.get(uid) == 2) {
            this.ans.add(root);
        }
        return uid;
    }

    public static void testcase1() {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.left.left = new TreeNode(4);
        n1.right = new TreeNode(3);
        n1.right.left = new TreeNode(2);
        n1.right.left.left = new TreeNode(4);
        n1.right.right = new TreeNode(4);
        FindDuplicateSubtrees solu = new FindDuplicateSubtrees();
        System.out.println(solu.findDuplicateSubtrees(n1));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
