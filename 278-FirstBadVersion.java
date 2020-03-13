package LeetCode;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */

public class FirstBadVersion {

    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left != nums.length && nums[left] == target) return left;
        return -1;
    }

    public int firstBadVersion1(int n) {
        int l = 0;
        int r = n;
        while (l <= n) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                if (mid - 1 >= 0 && !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                if (mid + 1 <= r && isBadVersion(mid + 1)) {
                    return mid + 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
