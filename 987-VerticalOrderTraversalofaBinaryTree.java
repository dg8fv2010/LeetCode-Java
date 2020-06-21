package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be
at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value
that is smaller.

Return an list of non-empty reports in order of X coordinate.
Every report will have a list of values of nodes.



Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.


Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
 */

public class VerticalOrderTraversalofaBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Location implements Comparable<Location> {
        int x;
        int y;
        int val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x) // left to right, x increases
                return Integer.compare(this.x, that.x);
            if (this.y != that.y) // top to bottom, y increases
                return Integer.compare(this.y, that.y);
            return Integer.compare(this.val, that.val);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Location> loc = new ArrayList<>();
        dfs(root, 0, 0, loc);
        Collections.sort(loc);

        List<List<Integer>> rst = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for (Location l : loc) {
            if (l.x != prev) {
                prev = l.x;
                rst.add(new ArrayList<>());
            }
            rst.get(rst.size() - 1).add(l.val);
        }
        return rst;
    }

    public void dfs(TreeNode root, int x, int y, List<Location> loc) {
        if (root == null) {
            return;
        }
        loc.add(new Location(x, y, root.val));
        dfs(root.left, x - 1, y + 1, loc);
        dfs(root.right, x + 1, y + 1, loc);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(3);

        VerticalOrderTraversalofaBinaryTree solu = new VerticalOrderTraversalofaBinaryTree();
        System.out.println(solu.verticalTraversal(n));
    }
}
