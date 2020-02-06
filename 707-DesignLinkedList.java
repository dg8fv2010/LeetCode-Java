package LeetCode;

/*
Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.


Example:

Input:
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1]]
Output:
[null,null,null,null,2,null,3]

Explanation:
MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3


Constraints:

0 <= index,val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 */

public class DesignLinkedList {
    private class Node {
        private int val;
        private Node next;

        public Node() {
            this.val = -1;
            this.next = null;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;

    /**
     * Initialize your data structure here.
     */
    public DesignLinkedList() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node curr = this.head;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }

        if (index == 0 && curr != null) {
            return curr.val;
        } else {
            return -1;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = this.head;
        this.head = n;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex1(int index, int val) {
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        Node curr = this.head;
        while (curr != null && index - 1 > 0) {
            curr = curr.next;
            index--;
        }

        if (index == 1) {
            Node n = new Node(val);
            Node next = curr.next;
            curr.next = n;
            n.next = next;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        Node prev = new Node(-1);
        prev.next = this.head;
        while (index > 0) {
            index--;
            prev = prev.next;
        }
        Node n = new Node(val);
        n.next = prev.next;
        prev.next = n;
    }


    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex1(int index) {
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        Node curr = this.head;
        while (curr != null && index - 1 > 0) {
            curr = curr.next;
            index--;
        }

        if (curr.next != null && index == 1) {
            curr.next = curr.next.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        Node prev = new Node(-1);
        prev.next = this.head;
        while (index > 0) {
            index--;
            prev = prev.next;
        }
        if (prev.next!=null) {
            prev.next = prev.next.next;
        }

    }


    public static void main(String[] args) {
        DesignLinkedList linkedList = new DesignLinkedList(); // Initialize empty LinkedList
        int a = 0;

//        linkedList.addAtHead(4);
//        a = linkedList.get(1);
//        linkedList.addAtHead(1);
//        linkedList.addAtHead(5);
//        linkedList.deleteAtIndex(3);

        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(7);


        linkedList.addAtIndex(0, 10);
        linkedList.addAtIndex(0, 20);
        linkedList.addAtIndex(1, 30);
        a = linkedList.get(1);


        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        a = linkedList.get(1);
        linkedList.deleteAtIndex(0);
        a = linkedList.get(0);


        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);


        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        a = linkedList.get(1);            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        a = linkedList.get(1);            // returns 3

    }
}
