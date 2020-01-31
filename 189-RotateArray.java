package LeetCode;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

public class RotateArray {
    // 使用了额外的空间
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] tmpArray = new int[nums.length - k];
        for (int i = 0; i < nums.length - k; i++) {
            tmpArray[i] = nums[i];
        }

        int idx = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            nums[idx++] = nums[i];
        }
        for (int i = 0; i < tmpArray.length; i++) {
            nums[idx++] = tmpArray[i];
        }
    }

    // 反转数组
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }

    // 使用的O(1)额外空间
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        int start = 0;

        while (count < nums.length) {
            int current_idx = start;
            int cur_num = nums[current_idx];
            do {
                int next_idx = (current_idx + k) % nums.length;
                int tmp = nums[next_idx];
                nums[next_idx] = cur_num;
                current_idx = next_idx;
                cur_num = tmp;
                count++;
            } while (current_idx != start);
            start++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        String[] b = {"dog", "racecar", "car"};
        String[] c = {"c", "acc", "ccc"};
        RotateArray solu = new RotateArray();
        solu.rotate3(a, 2);
        //System.out.println("1:" + solu.rotate(a, 3));
    }
}
