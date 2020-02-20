package LeetCode;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;
        TreeNode root = new TreeNode(preorder[pLeft]);
        int rootInInorder = 0;
        for (int i = iLeft; i < inorder.length; i++) {
            if (inorder[i] == preorder[pLeft]) {
                rootInInorder = i;
                break;
            }
        }
        root.left = helper(preorder, pLeft + 1, pLeft + rootInInorder - iLeft, inorder, iLeft, rootInInorder - 1);
        root.right = helper(preorder, pLeft + rootInInorder - iLeft + 1, pRight, inorder, rootInInorder + 1, iRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static void testcase1() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        ConstructBinaryTreefromPreorderandInorderTraversal solu = new ConstructBinaryTreefromPreorderandInorderTraversal();
        System.out.println(solu.buildTree(preorder, inorder));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
