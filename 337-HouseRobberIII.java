package LeetCode;

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

import java.util.HashMap;

public class HouseRobberIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return search(root, map);
    }

    public int search(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += search(root.left.left, map) + search(root.left.right, map);
        }
        if (root.right != null) {
            val += search(root.right.left, map) + search(root.right.right, map);
        }

        val = Math.max(val + root.val, search(root.left, map) + search(root.right, map));
        map.put(root, val);
        return val;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        HouseRobberIII solu = new HouseRobberIII();
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.right = new TreeNode(3);
        n.right.right = new TreeNode(1);
        System.out.println(solu.rob(n));
    }
}
