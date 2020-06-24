package LeetCode;

import java.util.Random;

/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result.
Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */

public class ShuffleanArray {

    private int[] arr;
    private int[] original;
    Random r;

    public ShuffleanArray(int[] nums) {
        this.arr = nums;
        this.original = nums.clone();
        this.r = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 1; i < this.arr.length; i++) {
            int rand = this.r.nextInt(i + 1);
            int tmp = this.arr[i];
            this.arr[i] = this.arr[rand];
            this.arr[rand] = tmp;
        }
        return this.arr;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ShuffleanArray solu = new ShuffleanArray(new int[]{1, 2, 3});
        System.out.println(solu.shuffle());
        System.out.println(solu.shuffle());
    }
}
