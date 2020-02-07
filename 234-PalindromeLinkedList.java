package LeetCode;

/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        PalindromeLinkedList.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }

        return dummy.next;
    }

    // 1. 快慢指针找中点
    // 2. 链表后半部分反转再比较
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
        }

        ListNode n1 = head;
        ListNode n2 = this.reverseList(slow);
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        //n2.next = n3;
        //n3.next = n4;
        //n4.next = n5;
        //n5.next = n6;
        //n6.next = n7;

        PalindromeLinkedList solu = new PalindromeLinkedList();
        System.out.println("1:" + solu.isPalindrome(n1));
    }
}
