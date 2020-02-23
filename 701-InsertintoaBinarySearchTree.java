package LeetCode;

public class InsertintoaBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }

        return root;
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) return;
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                dfs(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                dfs(root.right, val);
            }
        }
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        this.dfs(root, val);
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
