package LeetCode;

/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]


If there is no valid move, return an empty list [].
 */

import java.util.LinkedList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> rst = new LinkedList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String tmp = s.substring(0, i) + "--" + s.substring(i + 2);
                rst.add(tmp);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FlipGame solu = new FlipGame();
        solu.generatePossibleNextMoves("++++");
    }
}
