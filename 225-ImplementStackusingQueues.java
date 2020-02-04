package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

public class ImplementStackusingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackusingQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (this.q1.size() > 1) {
            this.q2.add(this.q1.poll());
        }
        int rst = this.q1.poll();
        Queue<Integer> tmp = this.q1;
        this.q1 = this.q2;
        this.q2 = tmp;
        return rst;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (this.q1.size() > 1) {
            this.q2.add(this.q1.poll());
        }
        int rst = this.q1.poll();
        Queue<Integer> tmp = this.q1;
        this.q1 = this.q2;
        this.q2 = tmp;
        this.q1.add(rst);
        return rst;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.q1.isEmpty() && this.q2.isEmpty();
    }


    public static void main(String[] args) {
        ImplementStackusingQueues solu = new ImplementStackusingQueues();
        solu.push(1);
        solu.push(2);
        int a = solu.top();  // returns 1
        a = solu.pop();   // returns 1
        boolean b = solu.empty(); // returns false
    }
}


class ImplementStackusingQueues1 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackusingQueues1() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.q2.add(x);
        while (!this.q1.isEmpty()) {
            this.q2.add(this.q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return this.q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.q1.isEmpty() && this.q2.isEmpty();
    }
}


class ImplementStackusingQueues2 {
    Queue<Integer> q1;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackusingQueues2() {
        this.q1 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.q1.add(x);
        int size = this.q1.size();
        while (size>1){
            this.q1.add(this.q1.poll());
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return this.q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.q1.isEmpty();
    }


    public static void main(String[] args) {
        ImplementStackusingQueues solu = new ImplementStackusingQueues();
        solu.push(1);
        solu.push(2);
        int a = solu.top();  // returns 1
        a = solu.pop();   // returns 1
        boolean b = solu.empty(); // returns false
    }
}
