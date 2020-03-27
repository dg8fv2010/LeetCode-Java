package LeetCode;

/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    // 题目要求只遍历一遍
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        int cnt = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode begin = null;
        ListNode end = dummy;
        while (end != null) {
            if (cnt == m) {
                begin = end;
            }
            if (cnt == n) {
                break;
            }
            cnt++;
            end = end.next;
            if (cnt < m) {
                prev = prev.next;
            }
        }

        ListNode start1 = prev;
        ListNode start2 = end.next;
        ListNode end2 = begin;
        end.next = null;
        prev = null;
        while (begin != null) {
            ListNode next = begin.next;
            begin.next = prev;
            prev = begin;
            begin = next;
        }
        start1.next = prev;
        end2.next = start2;
        return dummy.next;
    }
}
