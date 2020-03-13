package LeetCode;

/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6
 */

public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) return mid;
            if (guess(mid) < 0) r = mid - 1;
            else l = mid + 1;
        }
        return 0;
    }

    public int guess(int n) {
        if (n == 6) return 0;
        if (n > 6) return -1;
        else return 1;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        GuessNumberHigherorLower solu = new GuessNumberHigherorLower();
        System.out.println(solu.guessNumber(10));
    }
}
