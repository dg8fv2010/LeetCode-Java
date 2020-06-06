package LeetCode;

import java.util.Stack;

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 */

public class RecoverBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 中序遍历找到异常的位置，再进行交换
    // followup:
    // https://www.bilibili.com/video/av16260452/
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                if (prev != null) {
                    if (prev.val >= cur.val) {
                        if (first == null) {
                            first = prev;
                            second = cur;
                        } else {
                            second = cur;
                            break;
                        }
                    }
                }
                prev = cur;
                cur = cur.right;
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }

}
