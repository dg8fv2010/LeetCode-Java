package LeetCode;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

import java.util.Stack;

public class ConvertSortedArraytoBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;

        }
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static class Node {
        int low;
        int high;
        TreeNode t;

        Node(int low, int high, TreeNode t) {
            this.low = low;
            this.high = high;
            this.t = t;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<Node> stack = new Stack<>();
        TreeNode root = new TreeNode(nums[(nums.length - 1) / 2]);
        stack.push(new Node(0, nums.length - 1, root));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int mid = node.low + (node.high - node.low) / 2;

            if (mid - 1 >= node.low) {
                int leftmid = node.low + (mid - 1 - node.low) / 2;
                TreeNode leftnode = new TreeNode(nums[leftmid]);
                node.t.left = leftnode;
                stack.push(new Node(node.low, mid - 1, leftnode));
            }
            if (mid + 1 <= node.high) {
                int rightmid = mid + 1 + (node.high - mid - 1) / 2;
                TreeNode rightnode = new TreeNode(nums[rightmid]);
                node.t.right = rightnode;
                stack.push(new Node(mid + 1, node.high, rightnode));
            }
        }
        return root;
    }

    public static void testcase1() {
        int[] n = new int[]{-10, -3, 0, 5, 9};
        ConvertSortedArraytoBinarySearchTree solu = new ConvertSortedArraytoBinarySearchTree();
        System.out.println(solu.sortedArrayToBST(n));
    }

    public static void main(String[] args) {
        testcase1();
    }
}