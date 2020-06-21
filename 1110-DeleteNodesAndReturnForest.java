package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.



Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
 */

public class DeleteNodesAndReturnForest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> rst = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)) {
            rst.add(root);
        }
        delete(root, set, rst);
        return rst;
    }

    public TreeNode delete(TreeNode node, HashSet<Integer> set, List<TreeNode> rst) {
        if (node == null) {
            return null;
        }
        node.left = delete(node.left, set, rst);
        node.right = delete(node.right, set, rst);
        if (set.contains(node.val)) {
            if (node.left != null && !set.contains(node.left.val)) {
                rst.add(node.left);
            }
            if (node.right != null && !set.contains(node.right.val)) {
                rst.add(node.right);
            }
            return null;
        } else {
            return node;
        }
    }
}
