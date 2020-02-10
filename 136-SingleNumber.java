package LeetCode;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        return map.entrySet().iterator().next().getKey();
    }

    //If we take XOR of zero and some bit, it will return that bit
    //a⊕0=a
    //If we take XOR of two same bits, it will return 0
    //a⊕a=0
    //a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
    public int singleNumber(int[] nums) {
        int rst = 0;
        for (int num: nums) {
            rst = rst^num;
        }
        return rst;
    }

    public static void testcase1() {
        int[] a = new int[]{4, 1, 2, 1, 2};
        SingleNumber solu = new SingleNumber();
        int b = solu.singleNumber(a);
    }

    public static void main(String[] args) {
        testcase1();
    }

}
