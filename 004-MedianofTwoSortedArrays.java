package LeetCode;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class MedianofTwoSortedArrays {
    // https://www.bilibili.com/video/av67548632?from=search&seid=17849380480611483305
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int k = (m + n + 1) / 2;
        int l = 0;
        int r = m;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = k - i;
            if (i >= 1 && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else if (i < m && nums1[i] < nums2[j - 1]) {
                l = i + 1;
            } else {
                double sm = 0.0;
                if (i == 0) sm = nums2[j - 1];
                else if (j == 0) sm = nums1[i - 1];
                else sm = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1) return sm;

                double lg = 0.0;
                if (i == m) lg = nums2[j];
                else if (j == n) lg = nums1[i];
                else lg = Math.min(nums1[i], nums2[j]);
                return (sm + lg) / 2.0;
            }
        }
        return -1;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            return helper(nums1, nums2, 0, 0, n / 2 + 1);
        } else {
            return (helper(nums1, nums2, 0, 0, n / 2) + helper(nums1, nums2, 0, 0, n / 2 + 1)) / 2.0;
        }
    }

    public double helper(int[] nums1, int[] nums2, int start1, int start2, int n) {
        if (start1 >= nums1.length) return nums2[start2 + n - 1];
        if (start2 >= nums2.length) return nums1[start1 + n - 1];
        if (n == 1) return Math.min(nums1[start1], nums2[start2]);

        int half = Math.min(n / 2, Math.min(nums1.length - start1, nums2.length - start2));
        if (nums1[start1 + half - 1] < nums2[start2 + half - 1]) {
            return helper(nums1, nums2, start1 + half, start2, n - half);
        } else {
            return helper(nums1, nums2, start1, start2 + half, n - half);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MedianofTwoSortedArrays solu = new MedianofTwoSortedArrays();
        System.out.println(solu.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
