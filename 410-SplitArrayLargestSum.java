package LeetCode;

/*
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 */

public class SplitArrayLargestSum {
    // https://www.bilibili.com/video/av48806706?from=search&seid=14394718653696380306
    // 将n个元素的数组划分成n份，那么这些份数中的最大值就是数组的最大值
    // 将数组当成统一的一份不划分，最大值就是数组元素和
    // 分别当作二分中的上下边界，取中间值mid
    // 将数组划分成k份，保证k份的最大值不超过mid
    // 如果k大于m，表示mid小了，所以份数变多了，为了减小份数就要增大mid
    // 如果k小于等于m，表示划分成功，这个时候继续减小m，看看新划分的k是不是继续小于m
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int lo = max;
        int hi = sum;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int pieces = split(nums, mi);
            if (pieces > m) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public int split(int[] nums, int mid) {
        int piece = 1;
        int tmpSum = 0;
        for (int num : nums) {
            if (tmpSum + num > mid) {
                tmpSum = num;
                piece++;
            } else {
                tmpSum += num;
            }
        }
        return piece;
    }

}
