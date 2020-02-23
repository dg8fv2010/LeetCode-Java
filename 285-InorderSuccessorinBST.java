package LeetCode;

/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.



Example 1:



Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:



Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.


Note:

If the given node has no in-order successor in the tree, return null.
It's guaranteed that the values of the tree are unique.
 */


import java.util.Stack;

public class InorderSuccessorinBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (cur == p) {
                if (!stack.isEmpty()) {
                    return stack.pop();
                } else {
                    return null;
                }
            }
            cur = cur.right;
        }
        return null;
    }

    TreeNode pre;
    TreeNode suc;

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) return;
        dfs(root.left, p);
        if (this.pre == p) {
            this.suc = root;
        }
        this.pre = root;
        dfs(root.right, p);
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        this.pre = null;
        this.suc = null;
        this.dfs(root, p);
        return this.suc;
    }

    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        TreeNode rst = null;
        while (root != null) {
            if (root.val > p.val) {
                rst = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return rst;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left == null) {
                return root;
            } else {
                return left;
            }
        }
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(2);
        TreeNode p = new TreeNode(1);
        n.left = p;
        n.right = new TreeNode(3);

        InorderSuccessorinBST solu = new InorderSuccessorinBST();
        System.out.println(solu.inorderSuccessor(n, p));
    }

    public static void testcase2() {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(3);
        n.left.left = new TreeNode(2);
        n.left.right = new TreeNode(4);
        n.left.left.left = new TreeNode(1);
        TreeNode p = new TreeNode(6);
        n.right = p;
        InorderSuccessorinBST solu = new InorderSuccessorinBST();
        System.out.println(solu.inorderSuccessor(n, p));
    }

    public static void testcase3() {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(3);
        n.left.left = new TreeNode(2);
        TreeNode p = new TreeNode(4);
        n.left.right = p;
        n.left.left.left = new TreeNode(1);

        n.right = new TreeNode(6);
        InorderSuccessorinBST solu = new InorderSuccessorinBST();
        System.out.println(solu.inorderSuccessor(n, p));
    }

    public static void main(String[] args) {
        //testcase1();
        //testcase2();
        testcase3();
    }
}

