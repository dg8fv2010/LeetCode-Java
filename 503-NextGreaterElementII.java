package LeetCode;

/*Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.

 */

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] rst = new int[nums.length];
        Arrays.fill(rst, -1);
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < nums.length * 2) {
            int num = nums[i % nums.length];
            while (!st.isEmpty() && nums[st.peek()] < num) {
                rst[st.pop()] = num;
            }
            if (i < nums.length) {
                st.push(i);
            }
            i++;
        }
        return rst;
    }

    // 超时
    public int[] nextGreaterElements1(int[] nums) {
        int[] rst = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = i + 1;
            while (idx != i) {
                if (idx == nums.length) {
                    idx = 0;
                }
                if (nums[idx] > nums[i]) {
                    break;
                }
                idx++;
            }
            rst[i] = idx == i ? -1 : nums[idx];
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        NextGreaterElementII solu = new NextGreaterElementII();
        System.out.println(Arrays.toString(solu.nextGreaterElements(new int[]{1, 2, 1})));
    }
}
