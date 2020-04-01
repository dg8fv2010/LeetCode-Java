package LeetCode;

/*
Under a grammar given below, strings can represent a set of lowercase words.  Let's use R(expr) to denote the set of words the expression represents.

Grammar can best be understood through simple examples:

Single letters represent a singleton set containing that word.
R("a") = {"a"}
R("w") = {"w"}
When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
R("{a,b,c}") = {"a","b","c"}
R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
Formally, the 3 rules for our grammar:

For every lowercase letter x, we have R(x) = {x}
For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, and × denotes the cartesian product.
Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.



Example 1:

Input: "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]
Example 2:

Input: "{{a,z},a{b,c},{ab,z}}"
Output: ["a","ab","ac","z"]
Explanation: Each distinct word is written only once in the final answer.


Constraints:

1 <= expression.length <= 60
expression[i] consists of '{', '}', ','or lowercase English letters.
The given expression represents a set of words based on the grammar given in the description.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        return helper(expression, 0, expression.length() - 1);
    }

    public List<String> helper(String exp, int begin, int end) {
        List<List<String>> groups = new LinkedList<>();
        groups.add(new LinkedList<>());
        int level = 0;
        int i = 0;
        for (int k = begin; k <= end; k++) {
            char c = exp.charAt(k);
            if (c == '{') {
                level++;
                if (level == 1) {
                    i = k + 1;
                }
            } else if (c == '}') {
                level--;
                if (level == 0) {
                    List<String> group = helper(exp, i, k - 1);
                    merge_group(groups, group);
                }
            } else if (c == ',' && level == 0) {
                groups.add(new LinkedList<>());
            } else if (level == 0) {
                List<String> group = new LinkedList<>();
                group.add(String.valueOf(c));
                merge_group(groups, group);
            }
        }
        TreeSet<String> set = new TreeSet<>();
        for (List<String> g : groups) {
            set.addAll(g);
        }

        return new LinkedList<>(set);
    }

    public void merge_group(List<List<String>> groups, List<String> group) {
        if (groups.get(groups.size() - 1).size() == 0) {
            groups.set(groups.size() - 1, group);
            return;
        }
        List<String> rst = new LinkedList<>();
        for (String g1 : groups.get(groups.size() - 1)) {
            for (String g2 : group) {
                rst.add(g1 + g2);
            }
        }
        groups.set(groups.size() - 1, rst);
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        BraceExpansionII solu = new BraceExpansionII();
        System.out.println(solu.braceExpansionII("{a,b}{c,{d,e}}"));
        System.out.println(solu.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
}
