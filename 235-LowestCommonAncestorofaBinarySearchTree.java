package LeetCode;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]




Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.

 */

public class LowestCommonAncestorofaBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ans;

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            this.ans = root;
        }
        return (left + right + mid > 0);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        this.helper(root, p, q);
        return this.ans;
    }

    public TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > q.val) {
            return search(root.left, p, q);
        } else if (root.val < p.val) {
            return search(root.right, p, q);
        } else if (root.val < q.val && root.val > p.val) {
            return root;
        } else if (root == p || root == q) {
            return root;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return this.search(root, p, q);
        } else {
            return this.search(root, q, p);
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor3(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor3(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    public static void testcase1() {
        TreeNode r = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        r.left = p;
        r.left.left = new TreeNode(0);
        r.left.right = new TreeNode(4);
        r.left.right.left = new TreeNode(3);
        r.left.right.right = new TreeNode(5);
        TreeNode q = new TreeNode(8);
        r.right = q;
        r.right.left = new TreeNode(7);
        r.right.right = new TreeNode(9);

        LowestCommonAncestorofaBinarySearchTree solu = new LowestCommonAncestorofaBinarySearchTree();
        System.out.println(solu.lowestCommonAncestor(r, p, q));
    }

    public static void testcase2() {
        TreeNode r = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        r.left = p;
        r.left.left = new TreeNode(0);
        TreeNode q = new TreeNode(4);
        r.left.right = q;
        r.left.right.left = new TreeNode(3);
        r.left.right.right = new TreeNode(5);

        r.right = new TreeNode(8);
        r.right.left = new TreeNode(7);
        r.right.right = new TreeNode(9);

        LowestCommonAncestorofaBinarySearchTree solu = new LowestCommonAncestorofaBinarySearchTree();
        System.out.println(solu.lowestCommonAncestor(r, p, q));
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }
}
