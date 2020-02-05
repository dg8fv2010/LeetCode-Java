package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.
 */

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            q.add(rooms.get(0).get(i));
        }
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int key = q.poll();
                if (!visited[key]) {
                    visited[key] = true;
                    for (int j = 0; j < rooms.get(key).size(); j++) {
                        q.add(rooms.get(key).get(j));
                    }
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> r1 = new LinkedList<>();
        r1.add(1);
        r1.add(3);
        List<Integer> r2 = new LinkedList<>();
        r2.add(3);
        r2.add(0);
        r2.add(1);
        List<Integer> r3 = new LinkedList<>();
        r3.add(2);
        List<Integer> r4 = new LinkedList<>();
        r4.add(0);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        KeysandRooms solu = new KeysandRooms();
        System.out.println("1:" + solu.canVisitAllRooms(rooms));
    }
}
