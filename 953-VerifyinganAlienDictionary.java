package LeetCode;

/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographicaly in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅',
where '∅' is defined as the blank character which is less than any other character (More info).


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
 */

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        int idx = 0;
        for (char c : order.toCharArray()) {
            arr[c - 'a'] = idx++;
        }

        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i], arr)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(String a, String b, int[] arr) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)) {
            i++;
            j++;
        }
        if (i < a.length() && j < b.length()) {
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            return arr[ac - 'a'] < arr[bc - 'a'];
        } else {
            return a.length() < b.length();
        }

    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        VerifyinganAlienDictionary solu = new VerifyinganAlienDictionary();
        System.out.println(solu.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
