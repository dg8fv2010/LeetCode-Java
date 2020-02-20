package LeetCode;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode helper(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) return null;
        TreeNode root = new TreeNode(postorder[pRight]);
        int rootInInorder = 0;
        for (int i = iLeft; i < inorder.length; i++) {
            if (inorder[i] == postorder[pRight]) {
                rootInInorder = i;
                break;
            }
        }
        root.left = helper(inorder, iLeft, rootInInorder - 1, postorder, pLeft, pLeft + rootInInorder - iLeft - 1);
        root.right = helper(inorder, rootInInorder + 1, iRight, postorder, pLeft + rootInInorder - iLeft, pRight - 1);
        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return this.helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static void testcase1() {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        ConstructBinaryTreefromInorderandPostorderTraversal solu = new ConstructBinaryTreefromInorderandPostorderTraversal();
        System.out.println(solu.buildTree(inorder, postorder));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
