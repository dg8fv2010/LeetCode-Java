package LeetCode;

/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }

            if (nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            } else {
                i++;
            }

        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FirstMissingPositive solu = new FirstMissingPositive();
        //System.out.println(solu.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solu.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
