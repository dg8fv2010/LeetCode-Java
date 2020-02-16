package LeetCode;

/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5


return 4.
 */


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CountUnivalueSubtrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int rst;

    public boolean helper1(TreeNode root, int val) {
        if (root == null) return true;
        return root.val == val && helper1(root.left, val) && helper1(root.right, val);
    }

    // 所有的节点都需要遍历
    public int countUnivalSubtrees1(TreeNode root) {
        if (root == null) return rst;
        if (this.helper1(root, root.val)) this.rst++;
        countUnivalSubtrees1(root.left);
        countUnivalSubtrees1(root.right);
        return rst;
    }

    // |左右两边都要进行计算
    // || 只要有一边成立，另一边就不会计算
    public boolean helper2(TreeNode root, int val) {
        if (root == null) return true;
        if (!helper2(root.left, root.val) | !helper2(root.right, root.val)) {
            return false;
        }
        this.rst++;
        return root.val == val;
    }

    public int countUnivalSubtrees2(TreeNode root) {
        this.rst = 0;
        this.helper2(root, root.val);
        return this.rst;
    }

    // 用set来保存所有相同值子树的根节点
    // 对于我们遍历到的节点，如果其左右子节点均不存在，那么此节点为叶节点，符合题意，加入结果set中
    // 如果左子节点不存在，那么右子节点必须已经在结果set中，而且当前节点值需要和右子节点值相同才能将当前节点加入结果set中
    // 同样的，如果右子节点不存在，那么左子节点必须已经存在set中，而且当前节点值要和左子节点值相同才能将当前节点加入结果set中
    // 最后，如果左右子节点均存在，那么必须都已经在set中，并且左右子节点值都要和根节点值相同才能将当前节点加入结果set中
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode head = root;
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            if ((n.left == null && n.right == null) || n.left == head || n.right == head) {
                if (n.left == null && n.right == null) set.add(n);
                if (n.left == null && set.contains(n.right) && n.right.val == n.val) set.add(n);
                if (n.right == null && set.contains(n.left) && n.left.val == n.val) set.add(n);
                if (n.left != null && n.right != null &&
                        set.contains(n.left) && set.contains(n.right) &&
                        n.left.val == n.val && n.right.val == n.val) set.add(n);
                head = n;
            } else {
                if (n.right != null) st.add(n.right);
                if (n.left != null) st.add(n.left);
            }
        }
        return set.size();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(7);
        n.left = new TreeNode(1);
        n.left.left = new TreeNode(5);
        n.left.right = new TreeNode(5);
        n.right = new TreeNode(1);
        n.right.right = new TreeNode(1);
        CountUnivalueSubtrees solu = new CountUnivalueSubtrees();
        System.out.println(solu.countUnivalSubtrees(n));
    }

    public static void main(String[] args) {
        testcase1();
    }
}
