package LeetCode;

import java.util.Arrays;

/*
Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.

Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.



Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
Current array : [1,1,4,2,1,3]
Target array  : [1,1,1,2,3,4]
On index 2 (0-based) we have 4 vs 1 so we have to move this student.
On index 4 (0-based) we have 1 vs 3 so we have to move this student.
On index 5 (0-based) we have 3 vs 4 so we have to move this student.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0


Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100
 */

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int h : heights) {
            arr[h]++;
        }
        int cnt = 0;
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (heights[idx] != i) {
                    cnt++;
                }
                arr[i]--;
                idx++;
            }
        }
        return cnt;
    }

    public int heightChecker1(int[] heights) {
        int[] h2 = Arrays.copyOf(heights, heights.length);
        Arrays.sort(h2);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != h2[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        HeightChecker solu = new HeightChecker();
        System.out.println(solu.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
