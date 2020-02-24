package LeetCode;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.
 */

import java.util.PriorityQueue;

public class KthLargestElementinaStream {

    PriorityQueue<Integer> que;
    int k;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        this.que = new PriorityQueue<>(this.k);
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (this.que.size() < this.k) {
            this.que.offer(val);
        } else {
            if (this.que.peek() < val) {
                this.que.poll();
                this.que.offer(val);
            }
        }
        return this.que.peek();
    }

    public static void testcase() {
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargestElementinaStream kthLargest = new KthLargestElementinaStream(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }

    public static void main(String[] args) {
        testcase();
    }

}
