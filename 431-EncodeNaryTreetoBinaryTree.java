package LeetCode;

/*
Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. Similarly, a binary tree is a rooted tree in which each node has no more than 2 children. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that an N-ary tree can be encoded to a binary tree and this binary tree can be decoded to the original N-nary tree structure.

For example, you may encode the following 3-ary tree to a binary tree in this way:







Note that the above is just an example which might or might not work. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 */

import java.util.LinkedList;
import java.util.List;

public class EncodeNaryTreetoBinaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
            children = new LinkedList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
N-ary Tree:

      1
   /  |  \
  3   2   4
 / \
5   6


Binary Tree:

    1
   /
  3
 / \
5   2
 \   \
  6   4

     */

    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode rst = new TreeNode(root.val);
        if (!root.children.isEmpty()) {
            rst.left = encode(root.children.get(0));
        }
        TreeNode cur = rst.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return rst;
    }

    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node rst = new Node(root.val);
        TreeNode cur = root.left;
        while (cur != null) {
            rst.children.add(decode(cur));
            cur = cur.right;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        EncodeNaryTreetoBinaryTree solu = new EncodeNaryTreetoBinaryTree();
        Node n = new Node(1);
        Node n2 = new Node(3);
        n2.children.add(new Node(5));
        n2.children.add(new Node(6));
        n.children.add(n2);

        Node n3 = new Node(2);
        n.children.add(n3);

        n.children.add(new Node(4));
        TreeNode tn = solu.encode(n);
        Node nn = solu.decode(tn);
    }
}
