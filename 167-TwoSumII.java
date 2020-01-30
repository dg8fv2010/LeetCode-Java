package LeetCode;

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] rst = new int[2];

        rst[0]=0;
        rst[1]=numbers.length-1;
        while (rst[0]<rst[1]) {
            int tmp = numbers[rst[0]]+numbers[rst[1]];
            if (tmp == target) {
                break;
            } else if(tmp > target) {
                rst[1]--;
            } else {
                rst[0]++;
            }
        }
        rst[0]++;
        rst[1]++;
        return rst;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,7,11,15};
        String[] b = {"dog", "racecar", "car"};
        String[] c = {"c", "acc", "ccc"};
        TwoSumII solu = new TwoSumII();
        solu.twoSum(a, 9);
        //System.out.println("1:" + solu.twoSum(a, 9));
    }
}
