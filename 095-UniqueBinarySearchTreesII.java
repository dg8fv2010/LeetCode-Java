package LeetCode;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int l, int r) {
        List<TreeNode> rst = new LinkedList<>();
        if (l > r) {
            rst.add(null);
            return rst;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = helper(l, i - 1);
            List<TreeNode> right = helper(i + 1, r);
            for (TreeNode lt : left) {
                for (TreeNode rt : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    rst.add(root);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        UniqueBinarySearchTreesII solu = new UniqueBinarySearchTreesII();
        System.out.println(solu.generateTrees(3));
    }
}
