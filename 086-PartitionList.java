package LeetCode;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */

public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode sm = dummy1;
        ListNode lg = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                sm.next = cur;
                sm = sm.next;
            } else {
                lg.next = cur;
                lg = lg.next;
            }
            cur = cur.next;
        }
        sm.next = dummy2.next;
        lg.next = null;
        return dummy1.next;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        PartitionList solu = new PartitionList();
        solu.partition(n1, 3);
    }

}
