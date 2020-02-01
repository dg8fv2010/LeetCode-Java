package LeetCode;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */

import java.util.LinkedList;
import java.util.Queue;

public class MovingAveragefromDataStream {
    Queue<Integer> q;
    int size;
    int sum;

    public MovingAveragefromDataStream(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public int next(int val) {
        if (this.size == this.q.size()) {
            this.sum -= this.q.poll();
        }
        this.q.add(val);
        this.sum += val;
        this.size++;
        return this.sum / this.q.size();
    }
}
