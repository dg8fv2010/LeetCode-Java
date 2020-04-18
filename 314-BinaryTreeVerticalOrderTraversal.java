package LeetCode;

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        TreeMap<Integer, LinkedList<TreeNode>> map = new TreeMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        LinkedList<TreeNode> set = new LinkedList<>();
        set.add(root);
        map.put(0, set);
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            for (Map.Entry<Integer, LinkedList<TreeNode>> entry : map.entrySet()) {
                if (entry.getValue().contains(cur)) {
                    int idx = entry.getKey();
                    if (cur.left != null) {
                        if (!map.containsKey(idx - 1)) {
                            map.put(idx - 1, new LinkedList<>());
                        }
                        map.get(idx - 1).add(cur.left);
                        que.add(cur.left);
                    }
                    if (cur.right != null) {
                        if (!map.containsKey(idx + 1)) {
                            map.put(idx + 1, new LinkedList<>());
                        }
                        map.get(idx + 1).add(cur.right);
                        que.add(cur.right);
                    }
                    break;
                }
            }
        }

        for (Map.Entry<Integer, LinkedList<TreeNode>> entry : map.entrySet()) {
            List<Integer> list = new LinkedList<>();
            for (TreeNode n : entry.getValue()) {
                list.add(n.val);
            }
            rst.add(list);
        }

        return rst;
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
    }

    private static void testcase1() {
        BinaryTreeVerticalOrderTraversal solu = new BinaryTreeVerticalOrderTraversal();
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        System.out.println(solu.verticalOrder(n));
    }

    private static void testcase2() {
        BinaryTreeVerticalOrderTraversal solu = new BinaryTreeVerticalOrderTraversal();
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(8);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(0);
        n.right.left = new TreeNode(1);
        n.right.right = new TreeNode(7);
        System.out.println(solu.verticalOrder(n));
    }

    private static void testcase3() {
        BinaryTreeVerticalOrderTraversal solu = new BinaryTreeVerticalOrderTraversal();
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(8);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(0);
        n.left.right.left = new TreeNode(5);
        n.right.left = new TreeNode(1);
        n.right.left.right = new TreeNode(2);
        n.right.right = new TreeNode(7);
        System.out.println(solu.verticalOrder(n));
    }
}
