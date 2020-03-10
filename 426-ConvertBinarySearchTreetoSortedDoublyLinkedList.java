package LeetCode;

/*
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:





We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.





Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.



 */


import java.util.Stack;
import java.util.concurrent.TransferQueue;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node head = null;
        Node prev = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (head == null) head = cur;
            if (prev != null) {
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }

    public Node treeToDoublyList(Node root) {
        Node head = null;
        Node prev = null;
        dfs(root, prev, head);
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void dfs(Node root, Node prev, Node head) {
        if (root == null) return;
        dfs(root.left, prev, head);

        if (head == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        dfs(root.right, prev, head);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        Node n = new Node(4, null, null);
        n.left = new Node(2, null, null);
        n.right = new Node(5, null, null);
        n.left.left = new Node(1, null, null);
        n.left.right = new Node(3, null, null);
        ConvertBinarySearchTreetoSortedDoublyLinkedList solu = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
        solu.treeToDoublyList(n);
    }
}
