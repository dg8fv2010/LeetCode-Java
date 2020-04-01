package LeetCode;

/*
Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
 */

import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> rst = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(rst, graph, 0, list);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, int[][] graph, int cur, List<Integer> list) {
        if (cur == graph.length - 1) {
            rst.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            int n = graph[cur][i];
            list.add(n);
            dfs(rst, graph, n, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        AllPathsFromSourcetoTarget solu = new AllPathsFromSourcetoTarget();
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(solu.allPathsSourceTarget(graph));
    }
}
