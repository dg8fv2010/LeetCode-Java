package LeetCode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        AddTwoNumbers.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = l1;
        ListNode cur = l1;
        int count = 0;
        while (l1 != null || l2 != null) {
            cur.val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + count;
            if (cur.val >= 10) {
                count = cur.val / 10;
                cur.val = cur.val % 10;
            } else {
                count = 0;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (l1 != null) {
                cur.next = l1;
                cur = cur.next;
            } else if (l2 != null) {
                cur.next = l2;
                cur = cur.next;
            }

        }

        if (count > 0) {
            cur.next = new ListNode(count);
        }
        return rst;
    }

    static void testcase1() {
        ListNode n1 = new ListNode(2);
        ListNode n11 = new ListNode(4);
        ListNode n111 = new ListNode(3);
        n1.next = n11;
        n11.next = n111;

        ListNode n2 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n222 = new ListNode(4);
        n2.next = n22;
        n22.next = n222;

        AddTwoNumbers solu = new AddTwoNumbers();
        ListNode rst = solu.addTwoNumbers(n1, n2);
    }

    static void testcase2() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(5);

        AddTwoNumbers solu = new AddTwoNumbers();
        ListNode rst = solu.addTwoNumbers(n1, n2);
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }
}
