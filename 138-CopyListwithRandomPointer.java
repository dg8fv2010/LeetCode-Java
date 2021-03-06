package LeetCode;

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.


Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.


Constraints:

-10000 <= Node.val <= 10000
Node.random is null or pointing to a node in the linked list.
Number of Nodes will not exceed 1000.
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 用map保存两个节点的映射
    public Node copyRandomList1(Node head) {
        Node rst = new Node(-1);
        Node n = rst;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();

        while (cur != null) {
            Node tmp = new Node(cur.val);
            n.next = tmp;
            n = n.next;
            map.put(cur, n);
            cur = cur.next;
        }

        cur = head;
        n = rst.next;
        while (cur != null) {
            if (cur.random != null) {
                n.random = map.get(cur.random);
            }
            cur = cur.next;
            n = n.next;
        }
        return rst.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            Node t = new Node(cur.val);
            Node next = cur.next;
            cur.next = t;
            t.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node rst = head.next;
        while (cur != null) {
            Node t = cur.next;
            cur.next = cur.next.next;
            if (t.next != null) {
                t.next = t.next.next;
            }
            cur = cur.next;
        }
        return rst;
    }

}
