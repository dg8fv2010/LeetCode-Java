package LeetCode;

/*
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

public class ConvertSortedListtoBinarySearchTree {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 快慢指针找中点
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return func(head, null);
    }

    public TreeNode func(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = func(head, slow);
        root.right = func(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ListNode n = new ListNode(-10);
        n.next = new ListNode(-3);
        n.next.next = new ListNode(0);
        n.next.next.next = new ListNode(5);
        n.next.next.next.next = new ListNode(9);

        ConvertSortedListtoBinarySearchTree solu = new ConvertSortedListtoBinarySearchTree();
        solu.sortedListToBST(n);
    }
}
