package LeetCode;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int next = 1;
        while (next < nums.length) {
            while (idx < nums.length && nums[idx] != 0) {
                idx++;
            }
            next = Math.max(idx, next);
            while (next < nums.length) {
                if (nums[next] == 0) {
                    next++;
                } else {
                    break;
                }
            }
            if (next < nums.length) {
                int tmp = nums[idx];
                nums[idx] = nums[next];
                nums[next] = tmp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[last];
                nums[last] = tmp;
                last++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        int[] b = new int[]{2, 1};
        int[] c = new int[]{1, 2, 3};
        MoveZeroes solu = new MoveZeroes();
        solu.moveZeroes2(b);
        //System.out.println("1:" + solu.moveZeroes(c));
    }
}
