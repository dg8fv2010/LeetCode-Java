package LeetCode;

/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 */

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        if (target >= letters[r]) {
            return letters[0];
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] < target) {
                l = mid + 1;
            } else if (letters[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        FindSmallestLetterGreaterThanTarget solu = new FindSmallestLetterGreaterThanTarget();
        System.out.println(solu.nextGreatestLetter(new char[]{'c','f','j'}, 'a'));
        System.out.println(solu.nextGreatestLetter(new char[]{'c','f','j'}, 'c'));
        System.out.println(solu.nextGreatestLetter(new char[]{'c','f','j'}, 'd'));
        System.out.println(solu.nextGreatestLetter(new char[]{'c','f','j'}, 'g'));
        System.out.println(solu.nextGreatestLetter(new char[]{'c','f','j'}, 'j'));
        System.out.println(solu.nextGreatestLetter(new char[]{'c','f','j'}, 'k'));
    }
}
