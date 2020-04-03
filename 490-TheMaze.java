package LeetCode;

/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.



Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.



Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        HashMap<String, Boolean> visited = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        visited.put(start[0] + "-" + start[1], true);
        que.add(start[0] + "-" + start[1]);

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!que.isEmpty()) {
            String[] pos = que.poll().split("-");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            if (x == destination[0] && y == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int newx = x;
                int newy = y;
                while (newx >= 0 && newx < maze.length && newy >= 0 && newy < maze[0].length && maze[newx][newy] == 0) {
                    newx += dir[0];
                    newy += dir[1];
                }
                newx -= dir[0];
                newy -= dir[1];
                String newpos = newx + "-" + newy;
                if (!visited.containsKey(newpos)) {
                    visited.put(newpos, true);
                    que.add(newpos);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TheMaze solu = new TheMaze();
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0,},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(solu.hasPath(maze, new int[]{0, 4}, new int[]{4, 0}));
        System.out.println(solu.hasPath(maze, new int[]{0, 4}, new int[]{3, 2}));
    }
}
