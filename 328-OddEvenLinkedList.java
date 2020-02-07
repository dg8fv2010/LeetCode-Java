package LeetCode;

/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */

public class OddEvenLinkedList {
    public static class ListNode {
        int val;
        OddEvenLinkedList.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode even = head.next;
        ListNode n1 = head;
        ListNode n2 = head.next;

        while (n2!=null && n2.next!=null) {
            n1.next=n2.next;
            n1=n1.next;
            n2.next=n1.next;
            n2=n2.next;
        }

        n1.next=even;
        return head;
    }

        public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        //n6.next = n7;
        OddEvenLinkedList solu = new OddEvenLinkedList();
        System.out.println("1:" + solu.oddEvenList(n1));
    }
}
