package LeetCode;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, 0, l);
        int rst = 0;
        for (int n : l) {
            rst += n;
        }
        return rst;
    }

    public void dfs(TreeNode root, int cur, List<Integer> l) {
        if (root == null) {
            return;
        }
        
        int newVal = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            l.add(newVal);
            return;
        }
        dfs(root.left, newVal, l);
        dfs(root.right, newVal, l);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);

        SumRoottoLeafNumbers solu = new SumRoottoLeafNumbers();
        System.out.println(solu.sumNumbers(n));
    }
}
