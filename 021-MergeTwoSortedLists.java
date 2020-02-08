package LeetCode;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        MergeTwoSortedLists.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(-1);
        ListNode cur = rst;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return rst.next;
    }

    static void testcase1() {
        ListNode n1 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        ListNode n111 = new ListNode(4);
        n1.next = n11;
        n11.next = n111;

        ListNode n2 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n222 = new ListNode(4);
        n2.next = n22;
        n22.next = n222;

        MergeTwoSortedLists solu = new MergeTwoSortedLists(); // Initialize empty LinkedList
        ListNode rst = solu.mergeTwoLists(n1, n2);

    }

    public static void main(String[] args) {
        testcase1();
    }
}
