package LeetCode;

/*
Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Follow up:

Recursive solution is trivial, could you do it iteratively?



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]


Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
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

    public List<Integer> preorder1(Node root) {
        List<Integer> rst = new LinkedList<>();
        search(root, rst);
        return rst;
    }

    public void search(Node root, List<Integer> rst) {
        if (root == null) return;
        rst.add(root.val);
        for (Node n : root.children) {
            search(n, rst);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) return rst;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            rst.add(n.val);
            for (int i = n.children.size() - 1; i >= 0; i--) {
                stack.push(n.children.get(i));
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        NaryTreePreorderTraversal solu = new NaryTreePreorderTraversal();
        Node n = new Node(1);
        Node n2 = new Node(3);
        n2.children.add(new Node(5));
        n2.children.add(new Node(6));
        n.children.add(n2);

        Node n3 = new Node(2);
        n.children.add(n3);

        n.children.add(new Node(4));
        System.out.println(solu.preorder(n));
    }

}
