package LeetCode;

/*
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.


Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 先中序遍历获得有序队列
    // 再利用双指针向两边找
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        double dif = Double.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (Math.abs(list.get(i) - target) < dif) {
                dif = Math.abs(list.get(i) - target);
                idx = i;
            } else {
                break;
            }
        }

        int l = idx - 1;
        int r = idx;
        while (k > 0) {
            l = Math.max(l, 0);
            r = Math.min(r, list.size() - 1);
            if (Math.abs(list.get(l) - target) > Math.abs(list.get(r) - target)) {
                rst.add(list.get(r));
                r++;
            } else {
                rst.add(list.get(l));
                l--;
            }
            k--;
        }

        return rst;
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(4);
        n.left = new TreeNode(2);
        n.right = new TreeNode(5);
        n.left.left = new TreeNode(1);
        n.left.right = new TreeNode(3);
        n.right.left = new TreeNode(6);
        ClosestBinarySearchTreeValueII solu = new ClosestBinarySearchTreeValueII();
        System.out.println(solu.closestKValues(n, 3.5, 2));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
