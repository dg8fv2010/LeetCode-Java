package LeetCode;

/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5


Constraints:

The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [0, 10^4].
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree {
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

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int rst = 0;
        for (Node child : root.children) {
            rst = Math.max(rst, maxDepth(child));
        }
        return rst + 1;
    }

    public int maxDepth1(Node root) {
        if (root == null) return 0;
        int rst = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                for (Node child : n.children) {
                    q.add(child);
                }
            }
            rst++;
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MaximumDepthofNaryTree solu = new MaximumDepthofNaryTree();
        Node n = new Node(1);
        Node n2 = new Node(3);
        n2.children.add(new Node(5));
        n2.children.add(new Node(6));
        n.children.add(n2);

        Node n3 = new Node(2);
        n.children.add(n3);

        n.children.add(new Node(4));
        System.out.println(solu.maxDepth1(n));
    }
}
