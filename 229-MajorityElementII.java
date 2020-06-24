package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        int a = -1;
        int cnta = 0;
        int b = -1;
        int cntb = 0;

        for (int n : nums) {
            // 判定的顺序需要注意
            if (a == n) {
                cnta++;
                continue;
            }
            if (b == n) {
                cntb++;
                continue;
            }
            if (cnta == 0) {
                a = n;
                cnta = 1;
                continue;
            }
            if (cntb == 0) {
                b = n;
                cntb = 1;
                continue;
            }

            cnta--;
            cntb--;

        }

        cnta = 0;
        cntb = 0;
        for (int n : nums) {
            if (a == n) {
                cnta++;
            } else if (b == n) {
                cntb++;
            }
        }

        if (cnta > nums.length / 3) {
            rst.add(a);
        }
        if (cntb > nums.length / 3) {
            rst.add(b);
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MajorityElementII solu = new MajorityElementII();
        System.out.println(solu.majorityElement(new int[]{1, 2, 2, 3, 2, 1, 1, 3}));
        System.out.println(solu.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
