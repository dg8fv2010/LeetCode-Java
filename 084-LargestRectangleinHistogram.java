package LeetCode;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10
 */


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleinHistogram {
    // 找到局部峰值（比后一个值大即可）
    // 从局部峰值向前遍历
    public int largestRectangleArea1(int[] heights) {
        int rst = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }

            int minH = heights[i];
            for (int j = i; j >= 0; j--) {
                minH = Math.min(minH, heights[j]);
                int tmp = minH * (i - j + 1);
                rst = Math.max(rst, tmp);
            }
        }
        return rst;
    }

    public int largestRectangleArea(int[] heights) {
        List<Integer> h = new LinkedList<>();
        for (int height : heights) {
            h.add(height);
        }
        h.add(0);
        Stack<Integer> stack = new Stack<>();

        int rst = 0;
        for (int i = 0; i < h.size(); i++) {
            if (stack.isEmpty() || h.get(stack.peek()) < h.get(i)) {
                stack.push(i);
            } else {
                int cur = stack.pop();
                int tmp_width = 0;
                if (stack.isEmpty()) {
                    tmp_width = i;
                } else {
                    tmp_width = i - stack.peek() - 1;
                }
                rst = Math.max(rst, h.get(cur) * tmp_width);
                i--;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        LargestRectangleinHistogram solu = new LargestRectangleinHistogram();
        solu.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}
