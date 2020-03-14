package LeetCode;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] rst = new int[2];
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        rst[0] = l;

        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + (r - l) / 2);
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        rst[1] = r;
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        SearchforaRange solu = new SearchforaRange();
        System.out.println(solu.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
