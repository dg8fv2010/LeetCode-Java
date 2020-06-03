package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.



Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?



Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

public class KthSmallestElementinaBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // followup:
    // 修改原树结点的结构，使其保存包括当前结点和其左右子树所有结点的个数，这样就可以快速得到任何左子树结点总数来快速定位目标值了

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int cnt = count(root.left);

        if (cnt >= k) {
            return kthSmallest(root.left, k);
        } else if (k > cnt + 1) {
            return kthSmallest(root.right, k - 1 - cnt);
        }
        return root.val;

    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        int rst = root.val;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                k--;
                if (k == 0) {
                    rst = cur.val;
                    break;
                }
                cur = cur.right;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(1);
        n.right = new TreeNode(4);
        n.left.right = new TreeNode(2);
        KthSmallestElementinaBST solu = new KthSmallestElementinaBST();
        System.out.println(solu.kthSmallest(n, 1));
    }
}
