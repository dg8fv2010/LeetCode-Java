package LeetCode;

/*
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.


Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AllNodesDistanceKinBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> rst = new LinkedList<>();
        if (root == null) {
            return rst;
        }
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        search_parents(root, parents);
        HashSet<TreeNode> visited = new HashSet<>();
        search_node(rst, target, parents, visited, K);
        return rst;
    }

    public void search_parents(TreeNode root, HashMap<TreeNode, TreeNode> parents) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parents.put(root.left, root);
        }
        if (root.right != null) {
            parents.put(root.right, root);
        }
        search_parents(root.left, parents);
        search_parents(root.right, parents);
    }

    public void search_node(List<Integer> rst, TreeNode cur, HashMap<TreeNode, TreeNode> parents, HashSet<TreeNode> visited, int K) {
        if (cur == null || visited.contains(cur)) {
            return;
        }
        if (K == 0) {
            rst.add(cur.val);
            return;
        }
        visited.add(cur);
        if (cur.left != null) {
            search_node(rst, cur.left, parents, visited, K - 1);
        }
        if (cur.right != null) {
            search_node(rst, cur.right, parents, visited, K - 1);
        }
        if (parents.getOrDefault(cur, null) != null) {
            search_node(rst, parents.get(cur), parents, visited, K - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        n.left = n1;
        n.right = new TreeNode(1);
        n.left.left = new TreeNode(6);
        n.left.right = new TreeNode(2);
        n.right.left = new TreeNode(0);
        n.right.right = new TreeNode(8);
        n.left.right.left = new TreeNode(7);
        n.left.right.right = new TreeNode(4);
        AllNodesDistanceKinBinaryTree solu = new AllNodesDistanceKinBinaryTree();
        System.out.println(solu.distanceK(n, n1, 2));
    }
}
