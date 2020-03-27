package LeetCode;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseNodesinkGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode begin = head;
        ListNode end = head;
        do {
            int n = k;
            while (n > 1) {
                n--;
                if (end == null) {
                    break;
                }
                end = end.next;
            }
            if (end == null) {
                cur.next = begin;
                break;
            }
            ListNode newBegin = end.next;

            ListNode prev = null;
            while (begin != newBegin) {
                ListNode next = begin.next;
                begin.next = prev;
                prev = begin;
                begin = next;
            }
            cur.next = prev;
            while (cur.next != null) {
                cur = cur.next;
            }
            begin = newBegin;
            end = begin;
        } while (end != null);

        return dummy.next;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ReverseNodesinkGroup solu = new ReverseNodesinkGroup();
        // solu.reverseKGroup(n1, 2);  // 2-1-4-3-5
        solu.reverseKGroup(n1, 3);  // 2-1-4-3-5
    }
}
