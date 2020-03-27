package LeetCode;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */

import java.util.PriorityQueue;

public class MergekSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!q.isEmpty()) {
            ListNode n = q.poll();
            cur.next = n;
            cur = cur.next;
            if (n.next != null) {
                q.add(n.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (true) {
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int idx = 0;
            int cnt = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (min.val > lists[i].val) {
                        min = lists[i];
                        idx = i;
                    }
                } else {
                    cnt++;
                }
            }
            if (cnt == lists.length) {
                break;
            }
            cur.next = min;
            cur = cur.next;
            lists[idx] = lists[idx].next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        n7.next = n8;

        ListNode[] l = new ListNode[]{n1, n4, n7};
        MergekSortedLists solu = new MergekSortedLists();
        solu.mergeKLists(l);
    }
}
