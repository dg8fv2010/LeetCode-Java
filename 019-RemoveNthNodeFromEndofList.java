package LeetCode;

/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 */

public class RemoveNthNodeFromEndofList {
    public static class ListNode {
        int val;
        RemoveNthNodeFromEndofList.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // dummy节点
    // 双指针，距离差值为n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode h1 = dummy;
        ListNode h2 = dummy;

        while (n-- > 0) {
            h2 = h2.next;
        }

        while (h2.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        h1.next = h1.next.next;
        return  dummy.next;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        //n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        RemoveNthNodeFromEndofList solu = new RemoveNthNodeFromEndofList();
        System.out.println("1:" + solu.removeNthFromEnd(n1, 1));
    }
}
