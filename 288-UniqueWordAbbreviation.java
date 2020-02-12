package LeetCode;

/*
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 */

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbreviation {
    HashMap<String, HashSet<String>> map;

    public UniqueWordAbbreviation(String[] dictionary) {
        this.map = new HashMap<>();
        for (String str : dictionary) {
            String abbr = str;
            if (str.length() > 3) {
                abbr = str.substring(0, 1) + String.valueOf(str.length() - 2) + str.substring(str.length() - 1);
            }
            if (map.containsKey(abbr)) {
                map.get(abbr).add(str);
            } else {
                HashSet<String> set = new HashSet<>();
                set.add(str);
                map.put(abbr, set);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word.length() >= 3) return true;

        String abbr = word.substring(0, 1) + String.valueOf(word.length() - 2) + word.substring(word.length() - 1);
        if (!this.map.containsKey(abbr) || (this.map.containsKey(abbr) && this.map.get(abbr).size() == 1)) {
            return true;
        }
        return false;
    }
}
