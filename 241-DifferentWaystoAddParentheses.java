package LeetCode;

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    HashMap<String, List<Integer>> map = new HashMap<>();

    // 分治法，根据运算符将字符串分割成两个部分，分别进行计算
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rst = new LinkedList<>();
        if (map.containsKey(input)) {
            return map.get(input);
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (input.charAt(i) == '+') rst.add(l + r);
                        else if (input.charAt(i) == '-') rst.add(l - r);
                        else if (input.charAt(i) == '*') rst.add(l * r);
                    }
                }
            }
        }
        if (rst.size() == 0) {
            rst.add(Integer.parseInt(input));
        }
        map.put(input, rst);
        return rst;
    }
}
