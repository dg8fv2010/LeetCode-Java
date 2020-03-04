package LeetCode;

/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.



Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesinPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode rst = next.next;
        next.next = head;
        head.next = swapPairs(rst);
        return next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next!=null) {
            ListNode next = cur.next;
            ListNode rst = next.next;
            prev.next = next;
            next.next=cur;
            cur.next=rst;
            prev = cur;
            cur=rst;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SwapNodesinPairs solu = new SwapNodesinPairs();
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        ListNode t = solu.swapPairs1(n);
    }
}
