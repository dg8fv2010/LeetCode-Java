package LeetCode;

/*
Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?

Example:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: S = "time#bell#" and indexes = [0, 2, 5].


Note:

1 <= words.length <= 2000.
1 <= words[i].length <= 7.
Each word has only lowercase letters.
 */

import java.util.Arrays;

public class ShortEncodingofWords {
    public int minimumLengthEncoding2(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return b.length() - a.length();
        });
        StringBuilder rst = new StringBuilder();
        for (String word : words) {
            int pos = rst.lastIndexOf(word);
            if (pos < 0 || rst.charAt(pos + word.length()) != '#') {
                rst.append(word).append('#');
            }
        }
        return rst.length();
    }

    // 错误
    // 数组可以重新排序
    public int minimumLengthEncoding1(String[] words) {
        StringBuilder s = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < words.length; i++) {
            if (s.length() == 0 || s.charAt(s.length() - 1) == '#') {
                s.append(words[i]);
            } else {
                String word = words[i];
                int j = 0;
                for (j = word.length(); j >= 1; j--) {
                    int pos = s.indexOf(word.substring(0, j), idx);
                    if (pos > 0 && s.substring(pos).equals(word.substring(0, j))) {
                        s.append('#');
                        idx = s.length();
                        s.append(word.substring(j));
                        break;
                    }
                }
                if (j == 0) {
                    s.append('#').append(word);
                }
            }
        }
        return s.charAt(s.length() - 1) == '#' ? s.length() : s.length() + 1;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        ShortEncodingofWords solu = new ShortEncodingofWords();
        //System.out.println(solu.minimumLengthEncoding(new String[]{"me", "time"}));
        //System.out.println(solu.minimumLengthEncoding(new String[]{"time", "me"}));
        System.out.println(solu.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(solu.minimumLengthEncoding(new String[]{"time", "ikvt", "bell"}));
    }
}
