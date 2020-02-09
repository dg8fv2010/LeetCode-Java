package LeetCode;

/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode head, ListNode end) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        k = k % size;
        if (k == 0) return head;

        ListNode newHead = this.reverse(head, null);
        int t = k;
        ListNode end = newHead;
        while (t-- > 0) {
            end = end.next;
        }
        newHead = this.reverse(newHead, end);
        ListNode secondHead = this.reverse(end, null);
        cur = newHead;
        while (cur.next != null) cur = cur.next;
        cur.next = secondHead;
        return newHead;
    }

    // 先遍历整个链表，将尾节点连接到首节点
    // 从尾节点再向前移动n-k%n个节点，断开链表即可
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        cur.next = head;
        k = size - k % size;
        while (k-- > 0) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        return next;
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
        RotateList solu = new RotateList();
        solu.rotateRight(n1, 2);
        //System.out.println("1:" + solu.rotateRight(n1));
    }

    public static void testcase2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        RotateList solu = new RotateList();
        solu.rotateRight(n1, 0);
        //System.out.println("1:" + solu.rotateRight(n1));
    }

    public static void testcase3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        RotateList solu = new RotateList();
        solu.rotateRight(n1, 1);
        //System.out.println("1:" + solu.rotateRight(n1));
    }

    public static void main(String[] args) {
        testcase1();
        //testcase2();
        testcase3();
    }

}
