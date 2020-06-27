package LeetCode;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class RangeSumQueryMutable {

    private int size;
    private int[] tree;

    public RangeSumQueryMutable(int[] nums) {
        if (nums.length > 0) {
            this.size = nums.length;
            this.tree = new int[this.size * 2];
            buid(nums);
        }
    }

    private void buid(int[] nums) {
        for (int i = this.size, j = 0; j < this.size; i++, j++) {
            this.tree[i] = nums[j];
        }
        for (int i = this.size - 1; i >= 0; i--) {
            this.tree[i] = this.tree[i * 2] + this.tree[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        i += this.size;
        this.tree[i] = val;
        while (i > 0) {
            int l = i;
            int r = i;
            if (i % 2 == 0) {
                r++;
            } else {
                l--;
            }
            this.tree[i / 2] = this.tree[l] + this.tree[r];
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        i += this.size;
        j += this.size;
        int sum = 0;
        while (i <= j) {
            if (i % 2 != 0) {
                sum += this.tree[i];
                i++;
            }
            if (j % 2 != 1) {
                sum += this.tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}
