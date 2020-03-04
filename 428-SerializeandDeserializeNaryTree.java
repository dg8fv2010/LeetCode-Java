package LeetCode;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following 3-ary tree


      1
   /  |  \
  3   2   4
 / \
5   6


as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

import java.util.*;

public class SerializeandDeserializeNaryTree {
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

    public String serialize(Node root) {
        if (root == null) return "";
        List<String> list = new LinkedList<>();
        serialize_helper(root, list);
        return String.join(",", list);
    }

    public void serialize_helper(Node root, List<String> list) {
        if (root == null) return;
        list.add(String.valueOf(root.val));
        int size = root.children.size();
        list.add(String.valueOf(size));
        for (int i = 0; i < size; i++) {
            serialize_helper(root.children.get(i), list);
        }
    }

    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize_helper(q);
    }

    public Node deserialize_helper(Queue<String> q) {
        Node root = new Node(Integer.parseInt(q.poll()));
        int size = Integer.parseInt(q.poll());
        for (int i = 0; i < size; i++) {
            root.children.add(deserialize_helper(q));
        }
        return root;
    }


    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SerializeandDeserializeNaryTree solu = new SerializeandDeserializeNaryTree();
        Node n = new Node(1);
        Node n2 = new Node(3);
        n2.children.add(new Node(5));
        n2.children.add(new Node(6));
        n.children.add(n2);

        Node n3 = new Node(2);
        n.children.add(n3);

        n.children.add(new Node(4));
        System.out.println(solu.serialize(n)); // 1,3,3,2,5,0,6,0,2,0,4,0
    }
}
