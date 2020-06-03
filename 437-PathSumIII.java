package LeetCode;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf,
but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

public class PathSumIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int rst = search(root, sum);
        rst += pathSum(root.left, sum);
        rst += pathSum(root.right, sum);
        return rst;
    }

    public int search(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int cnt = 0;
        if (root.val == sum) {
            cnt++;
        }
        return cnt + search(root.left, sum - root.val) + search(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(5);
        n.right = new TreeNode(-3);
        n.left.left = new TreeNode(3);
        n.left.right = new TreeNode(2);
        n.left.left.left = new TreeNode(3);
        n.left.left.right = new TreeNode(-2);
        n.left.right.right = new TreeNode(1);
        n.right.right = new TreeNode(11);

        PathSumIII solu = new PathSumIII();
        System.out.println(solu.pathSum(n, 8));
    }
}
