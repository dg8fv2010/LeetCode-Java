package LeetCode;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int rst = 0;
        while (l < r) {
            int mn = Math.min(height[l], height[r]);
            if (height[l] == mn) {
                l++;
                while (l < r && height[l] < mn) {
                    rst += (mn - height[l]);
                    l++;
                }
            } else {
                r--;
                while (l < r && height[r] < mn) {
                    rst += (mn - height[r]);
                    r--;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TrappingRainWater solu = new TrappingRainWater();
        System.out.println(solu.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
