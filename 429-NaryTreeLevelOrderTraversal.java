package LeetCode;

/*
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]


Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> rst = new LinkedList<>();
        if (root==null) return rst;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                l.add(n.val);
                for (Node child : n.children) {
                    queue.add(child);
                }
            }
            rst.add(l);
        }
        return rst;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rst = new LinkedList<>();
        search(root, 0, rst);
        return rst;
    }

    public void search(Node root, int level, List<List<Integer>> rst) {
        if (root == null) return;
        if (level == rst.size()) {
            rst.add(new LinkedList<>());
        }
        rst.get(level).add(root.val);
        for (Node child : root.children) {
            search(child, level + 1, rst);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        NaryTreeLevelOrderTraversal solu = new NaryTreeLevelOrderTraversal();
        Node n = new Node(1);
        Node n2 = new Node(3);
        n2.children.add(new Node(5));
        n2.children.add(new Node(6));
        n.children.add(n2);

        Node n3 = new Node(2);
        n.children.add(n3);

        n.children.add(new Node(4));
        System.out.println(solu.levelOrder(n));
    }
}
