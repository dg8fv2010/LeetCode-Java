package LeetCode;

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.


Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100
 */

public class PopulatingNextRightPointersinEachNodeII {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        Node(int x) {
            val = x;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect1(Node root) {
        if (root == null) return null;
        Node p = root.next;
        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = p;
            }
        }
        if (root.right != null) {
            root.right.next = p;
        }
        connect1(root.right); // 先right再left
        connect1(root.left);
        return root;
    }

    // 不需要额外空间
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node cur = dummy;
        Node head = root;
        while (root != null) {
            if (root.left != null) {
                cur.next = root.left;
                cur = cur.next;
            }
            if (root.right != null) {
                cur.next = root.right;
                cur = cur.next;
            }
            root = root.next;
            if (root == null) {
                cur = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return head;
    }

    public static void testcase1() {
        Node n = new Node(2);
        n.left = new Node(1);
        n.right = new Node(3);
        n.left.left = new Node(0);
        n.left.right = new Node(7);
        n.right.left = new Node(9);
        n.right.right = new Node(1);
        n.left.left.left = new Node(2);
        n.left.right.left = new Node(1);
        n.left.right.right = new Node(0);
        n.right.right.left = new Node(8);
        n.right.right.right = new Node(8);
        PopulatingNextRightPointersinEachNodeII solu = new PopulatingNextRightPointersinEachNodeII();
        System.out.println(solu.connect(n));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
