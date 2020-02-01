package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Your implementation should support following operations:

MyCircularQueue(k): Constructor, set the size of the queue to be k.
Front: Get the front item from the queue. If the queue is empty, return -1.
Rear: Get the last item from the queue. If the queue is empty, return -1.
enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
isEmpty(): Checks whether the circular queue is empty or not.
isFull(): Checks whether the circular queue is full or not.


Example:

MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
circularQueue.enQueue(1);  // return true
circularQueue.enQueue(2);  // return true
circularQueue.enQueue(3);  // return true
circularQueue.enQueue(4);  // return false, the queue is full
circularQueue.Rear();  // return 3
circularQueue.isFull();  // return true
circularQueue.deQueue();  // return true
circularQueue.enQueue(4);  // return true
circularQueue.Rear();  // return 4

Note:

All values will be in the range of [0, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in Queue library.
 */

public class DesignCircularQueue {
    private List<Integer> q;
    private int head = -1;
    private int tail = -1;
    int size = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public DesignCircularQueue(int k) {
        this.q = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            this.q.add(0);
        }
        this.size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.size >= q.size()) {
            return false;
        }
        if (head == -1) {
            this.head = 0;
        }
        this.size++;
        this.tail++;
        if (this.tail == q.size()) {
            this.tail=0;
        }
        this.q.set(this.tail, value);

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.size <= 0) {
            return false;
        }
        this.head++;
        this.size--;
        if (this.head >= this.q.size()) {
            this.head = 0;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.size == 0) {
            return -1;
        }
        return this.q.get(this.head);
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.size == 0) {
            return -1;
        }
        return this.q.get(this.tail);
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.size == this.q.size();
    }

    public static void main(String[] args) {
        DesignCircularQueue circularQueue = new DesignCircularQueue(3);
        boolean a = circularQueue.enQueue(2);
        int b = circularQueue.Rear();
        b = circularQueue.Front();
        a = circularQueue.deQueue();
        b = circularQueue.Front();
        a = circularQueue.deQueue();
        b = circularQueue.Front();

        b = circularQueue.Rear();
        a = circularQueue.deQueue();
        a = circularQueue.enQueue(5);
        b = circularQueue.Rear();
        a = circularQueue.deQueue();
        b = circularQueue.Front();
    }
}
