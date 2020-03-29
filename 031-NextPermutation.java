package LeetCode;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1) {
            Arrays.sort(nums);
            return;
        }

        int idx2 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[idx]) {
                idx2 = i;
                break;
            }
        }
        int tmp = nums[idx2];
        nums[idx2] = nums[idx];
        nums[idx] = tmp;
        Arrays.sort(nums, idx + 1, nums.length);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        NextPermutation solu = new NextPermutation();
        solu.nextPermutation(new int[]{1, 1, 5});
    }
}
