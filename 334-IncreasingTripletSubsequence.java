package LeetCode;

/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
 */

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (m1 >= num) m1 = num;
            else if (m2 >= num) m2 = num;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        IncreasingTripletSubsequence solu = new IncreasingTripletSubsequence();
        System.out.println(solu.increasingTriplet(new int[]{5, 6, 1, 7}));
    }
}
