package LeetCode;

import java.util.Arrays;

/*
You are given a char array representing tasks CPU need to do. It contains capital letters A to Z
where each letter represents a different task. Tasks could be done without the original order of the array.
Each task is done in one unit of time. For each unit of time,
the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period
between two same tasks (the same letter in the array),
that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.



Example 1:

Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ['A','A','A','B','B','B'], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
['A','A','A','B','B','B']
['A','B','A','B','A','B']
['B','B','B','A','A','A']
...
And so on.
Example 3:

Input: tasks = ['A','B','C','D','E','A','B','C','D','E'], n = 4
Output: 10


Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        Arrays.sort(arr);
        int mx = arr[25];
        int i = 25;
        while (i >= 0 && mx == arr[i]) {
            i--;
        }
        return Math.max(tasks.length, (mx - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        TaskScheduler solu = new TaskScheduler();
        System.out.println(solu.leastInterval(new char[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'}, 2));
        System.out.println(solu.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(solu.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println(solu.leastInterval(new char[]{'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'}, 4));
    }
}
