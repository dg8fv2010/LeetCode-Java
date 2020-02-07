package LeetCode;

/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */

public class RemoveLinkedListElements {
    public static class ListNode {
        int val;
        RemoveLinkedListElements.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode RemoveLinkedListElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        RemoveLinkedListElements solu = new RemoveLinkedListElements();
        System.out.println("1:" + solu.RemoveLinkedListElements(n1, 6));
    }
}
