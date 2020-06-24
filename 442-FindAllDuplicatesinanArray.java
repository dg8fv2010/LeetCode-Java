package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        // 遍历数组并取反
        // 如果发现已经是负数，表示出现了第二次
        List<Integer> rst = new ArrayList<>();
        for (int n : nums) {
            int cur = Math.abs(n);
            if (nums[cur - 1] < 0) {
                rst.add(cur);
            } else {
                nums[cur - 1] = -nums[cur - 1];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FindAllDuplicatesinanArray solu = new FindAllDuplicatesinanArray();
        System.out.println(solu.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
