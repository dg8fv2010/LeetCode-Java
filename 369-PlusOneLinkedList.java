package LeetCode;

/*
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
 */

public class PlusOneLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode plusOne(ListNode head) {
        ListNode reverse = reverse(head);
        int carry = 1;
        ListNode prev = null;
        ListNode cur = reverse;
        while (cur != null) {
            int tmp = cur.val + carry;
            cur.val = tmp % 10;
            carry = tmp / 10;
            prev = cur;
            cur = cur.next;
        }
        cur = prev;
        if (carry > 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return reverse(reverse);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse2(head);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        PlusOneLinkedList solu = new PlusOneLinkedList();
        solu.plusOne(n);
    }
}
