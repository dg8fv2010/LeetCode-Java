package LeetCode;

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

import java.util.Stack;

public class AddTwoNumbersII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> st = new Stack<>();
        int carry = 0;
        while (!st1.isEmpty() && !st2.isEmpty()) {
            int tmp = st1.pop() + st2.pop() + carry;
            carry = tmp / 10;
            tmp %= 10;
            st.push(tmp);
        }
        while (!st1.isEmpty()) {
            int tmp = st1.pop() + carry;
            carry = tmp / 10;
            tmp %= 10;
            st.push(tmp);
        }
        while (!st2.isEmpty()) {
            int tmp = st2.pop() + carry;
            carry = tmp / 10;
            tmp %= 10;
            st.push(tmp);
        }
        if (carry > 0) {
            st.push(carry);
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!st.isEmpty()) {
            cur.next = new ListNode(st.pop());
            cur = cur.next;
        }
        return dummy.next;
    }
}
