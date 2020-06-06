package LeetCode;

/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree:

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
Follow up:
Could you do it using only constant space complexity?
 */

public class VerifyPreorderSequenceinBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        return check(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean check(int[] preorder, int l, int r, int low, int high) {
        if (l >= r) {
            return true;
        }
        int root = preorder[l];
        if (root <= low || root >= high) {
            return false;
        }
        int idx = l + 1;
        while (idx <= r && preorder[idx] < root) {
            idx++;
        }

        return check(preorder, l + 1, idx, low, root) && check(preorder, idx, r, root, high);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        VerifyPreorderSequenceinBinarySearchTree solu = new VerifyPreorderSequenceinBinarySearchTree();
        System.out.println(solu.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
        System.out.println(solu.verifyPreorder(new int[]{5, 2, 16, 1, 3}));
    }
}
