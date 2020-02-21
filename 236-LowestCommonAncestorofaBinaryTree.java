package LeetCode;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */


import javafx.util.Pair;

import java.util.*;

public class LowestCommonAncestorofaBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ans;

    public boolean search(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) return false;
        int left = search(current.left, p, q) ? 1 : 0;
        int right = search(current.right, p, q) ? 1 : 0;
        int mid = (current == p || current == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            this.ans = current;
        }
        return (left + right + mid > 0);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        this.search(root, p, q);
        return ans;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> map = new LinkedHashMap<>();
        stack.push(root);
        map.put(root, null);

        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode n = stack.pop();
            if (n.left != null) {
                map.put(n.left, n);
                stack.push(n.left);
            }
            if (n.right != null) {
                map.put(n.right, n);
                stack.push(n.right);
            }
        }

        Set<TreeNode> set = new LinkedHashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int BOTH_PENDING = 2;
        int LEFT_DONE = 1;
        int BOTH_DONE = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, BOTH_PENDING));
        boolean one_node_found = false;
        TreeNode LCA = null;
        TreeNode child_node = null;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_status = top.getValue();

            if (parent_status != BOTH_DONE) {
                if (parent_status == BOTH_PENDING) {
                    if (parent_node == p || parent_node == q) {
                        if (one_node_found) {
                            return LCA;
                        } else {
                            one_node_found = true;
                            LCA = parent_node;
                        }
                    }
                    child_node = parent_node.left;
                } else {
                    child_node = parent_node.right;
                }

                stack.pop();
                stack.push(new Pair<>(parent_node, parent_status - 1));

                if (child_node != null) {
                    stack.push(new Pair<>(child_node, BOTH_PENDING));
                }
            } else {
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        // Three static flags to keep track of post-order traversal.

        // Both left and right traversal pending for a node.
        // Indicates the nodes children are yet to be traversed.
        int BOTH_PENDING = 2;

        // Left traversal done.
        int LEFT_DONE = 1;

        // Both left and right traversal done for a node.
        // Indicates the node can be popped off the stack.
        int BOTH_DONE = 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();

        // Initialize the stack with the root node.
        stack.push(new Pair<TreeNode, Integer>(root, BOTH_PENDING));

        // This flag is set when either one of p or q is found.
        boolean one_node_found = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // Child node
        TreeNode child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != BOTH_DONE) {

                // If both child traversals are pending
                if (parent_state == BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if (parent_node == p || parent_node == q) {

                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            one_node_found = true;

                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }

                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else {
                    // traverse right child
                    child_node = parent_node.right;
                }

                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, BOTH_PENDING));
                }
            } else {

                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }
        return null;
    }

    public static void testcase() {
        TreeNode r = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        r.left = p;
        r.left.left = new TreeNode(6);
        r.left.right = new TreeNode(2);
        r.left.right.left = new TreeNode(7);
        r.left.right.right = new TreeNode(4);
        TreeNode q = new TreeNode(1);
        r.right = q;
        r.right.left = new TreeNode(0);
        r.right.right = new TreeNode(8);

        LowestCommonAncestorofaBinaryTree solu = new LowestCommonAncestorofaBinaryTree();
        System.out.println(solu.lowestCommonAncestor(r, p, q));
    }

    public static void main(String[] args) {
        testcase();
    }
}
