package LeetCode;

import java.util.Stack;

class MinStack1 {
    Stack<Integer> s;
    Stack<Integer> s_min;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
        this.s = new Stack<>();
        this.s_min = new Stack<>();
    }

    public void push(int x) {
        this.s.push(x);
        if (this.s_min.size() == 0 || x <= this.s_min.peek()) {
            s_min.push(x);
        }
    }

    public void pop() {
        int t = this.s.pop();
        if (t == this.s_min.peek()) {
            this.s_min.pop();
        }
    }

    public int top() {
        return this.s.peek();
    }

    public int getMin() {
        return this.s_min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        int a = minStack.getMin();
        minStack.pop();
        a = minStack.getMin();
    }
}


public class MinStack {
    Stack<Integer> s;
    int min_val;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.s = new Stack<>();
        this.min_val = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < this.min_val) {
            this.s.push(this.min_val);
            this.min_val = x;
        }
        this.s.push(x);
    }

    public void pop() {
        int t = this.s.pop();
        if (t == this.min_val) {
            this.min_val = this.s.pop();
        }
    }

    public int top() {
        return this.s.peek();
    }

    public int getMin() {
        return this.min_val;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(0);
        minStack.push(-2);
        int a = minStack.getMin();
        minStack.pop();
        a = minStack.getMin();
    }
}
