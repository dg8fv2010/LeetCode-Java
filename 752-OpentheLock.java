package LeetCode;

import javafx.util.Builder;

import java.util.*;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 */

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        int rst = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();
        q.add("0000");
        visited.addAll(Arrays.asList(deadends));
        if (visited.contains(target)) {
            return -1;
        }

        while (!q.isEmpty()) {
            List<String> currents = new ArrayList<>(q.size());
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (visited.contains(cur)) {
                    continue;
                }
                currents.add(cur);
            }
            if (currents.size() > 0) {
                rst++;
            }
            for (int i = 0; i < currents.size(); i++) {
                String cur = currents.get(i);
                if (cur.equals(target)) {
                    return rst - 1;
                }
                visited.add(cur);
                for (int k = 0; k < 4; k++) {
                    int tmp = cur.charAt(k) - '0';
                    int up = tmp == 9 ? 0 : tmp + 1;
                    int down = tmp == 0 ? 9 : tmp - 1;

                    StringBuilder str_builder = new StringBuilder(cur);
                    str_builder.setCharAt(k, (char) (up + '0'));
                    String str_up = str_builder.toString();

                    if (!visited.contains(str_up)) {
                        q.add(str_up);
                    }

                    str_builder.setCharAt(k, (char) (down + '0'));
                    String str_down = str_builder.toString();
                    if (!visited.contains(str_down)) {
                        q.add(str_down);
                    }

                }
            }
        }

        return -1;
    }

    public int openLock1(String[] deadends, String target) {
        int rst = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();
        Set<String> deadsets = new LinkedHashSet<>(Arrays.asList(deadends));
        if (deadsets.contains(target) || deadsets.contains("0000")) {
            return -1;
        }
        visited.add("0000");
        q.add("0000");
        while (!q.isEmpty()) {
            rst++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        String next = cur.substring(0, j) + ((int) cur.charAt(j) - (int) '0' + k + 10) % 10 + cur.substring(j + 1);
                        if (!deadsets.contains(next) && !visited.contains(next)) {
                            if (next.equals(target)) {
                                return rst;
                            }
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        OpentheLock solu = new OpentheLock();
        System.out.println("1:" + solu.openLock1(a, "8888"));
    }
}
