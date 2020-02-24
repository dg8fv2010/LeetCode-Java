package LeetCode;

/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 */

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + k + 1 && j < nums.length; j++) {
                long tmp = Math.abs((long) nums[j] - (long) nums[i]);
                if (tmp <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode add(TreeNode root, TreeNode newNode) {
        if (root == null) return newNode;
        if (root.val > newNode.val) {
            root.left = add(root.left, newNode);
        } else {
            root.right = add(root.right, newNode);
        }
        return root;
    }

    public boolean search(TreeNode root, int target, int t) {
        if (root == null) return false;
        long tmp = (long) root.val - (long) target;
        if (Math.abs(tmp) <= t) {
            return true;
        }

        if (tmp > t) return search(root.left, target, t);
        else return search(root.right, target, t);
    }

    public TreeNode del(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root.left;
        else {
            TreeNode n = root.right;
            while (n.left != null) n = n.left;
            n.left = root.left;
            return n;
        }
    }

    public TreeNode delete(TreeNode root, TreeNode target) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur == target) break;
            prev = cur;
            if (cur.val > target.val) cur = cur.left;
            else cur = cur.right;
        }

        if (prev == null) return del(cur);
        if (prev.left != null && prev.left == target) prev.left = del(cur);
        else prev.right = del(cur);
        return root;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) return false;

        TreeNode[] map = new TreeNode[nums.length];
        map[0] = new TreeNode(nums[0]);
        TreeNode root = null;
        root = this.add(root, map[0]);
        for (int i = 1; i < nums.length; i++) {
            if (this.search(root, nums[i], t)) {
                return true;
            }
            map[i] = new TreeNode(nums[i]);
            if (i - k >= 0) {
                root = this.delete(root, map[i - k]);
            }
            root = this.add(root, map[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0) {
                treeset.remove(nums[i - k - 1]);
            }

            if (treeset.ceiling(nums[i]) != null) {
                long tmp = Math.abs((long) treeset.ceiling(nums[i]) - (long) nums[i]);
                if (tmp <= t) return true;
            }
            if (treeset.floor(nums[i]) != null) {
                long tmp = Math.abs((long) treeset.floor(nums[i]) - (long) nums[i]);
                if (tmp <= t) return true;
            }
            treeset.add(nums[i]);
        }
        return false;
    }

    public static void testcase1() {
        int[] n = new int[]{1, 2, 3, 1};
        ContainsDuplicateIII solu = new ContainsDuplicateIII();
        System.out.println(solu.containsNearbyAlmostDuplicate(n, 3, 0));
    }

    public static void testcase2() {
        int[] n = new int[]{1, 0, 1, 1};
        ContainsDuplicateIII solu = new ContainsDuplicateIII();
        System.out.println(solu.containsNearbyAlmostDuplicate(n, 1, 2));
    }

    public static void testcase3() {
        int[] n = new int[]{1, 5, 9, 1, 5, 9};
        ContainsDuplicateIII solu = new ContainsDuplicateIII();
        System.out.println(solu.containsNearbyAlmostDuplicate(n, 2, 3));
    }

    public static void testcase4() {
        int[] n = new int[]{-1, 2147483647};
        ContainsDuplicateIII solu = new ContainsDuplicateIII();
        System.out.println(solu.containsNearbyAlmostDuplicate(n, 1, 2147483647));
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
        testcase4();
    }
}
