package LeetCode;

/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 */


public class DeleteNodeinaBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 适用于所有二叉树的通用解法
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode n = root.right;
                while (n.left != null) n = n.left;
                int tmp = root.val;
                root.val = n.val;
                n.val = tmp;
            }
        }

        root.left = this.deleteNode1(root.left, key);
        root.right = this.deleteNode1(root.right, key);
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode2(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode2(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null && root.right != null) {
                TreeNode cur = root.right;
                while (cur.left != null) cur = cur.left;
                root.val = cur.val;
                root.right = deleteNode2(root.right, cur.val);
            } else {
                root = root.left != null ? root.left : root.right;
            }
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val == key) break;
            prev = cur;
            if (cur.val > key) cur = cur.left;
            else cur = cur.right;
        }

        if (prev == null) return this.del(cur);
        if (prev.left != null && prev.left.val == key) prev.left = del(cur);
        else prev.right = del(cur);
        return root;
    }

    public TreeNode del(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root.left;
        TreeNode n = root.right;
        while (n.left != null) n = n.left;
        n.left = root.left;
        return root.right;
    }

    public static void testcase() {
        TreeNode n = new TreeNode(0);
        DeleteNodeinaBST solu = new DeleteNodeinaBST();
        solu.deleteNode(n, 0);
    }

    public static void main(String[] args) {
        testcase();
    }
}
