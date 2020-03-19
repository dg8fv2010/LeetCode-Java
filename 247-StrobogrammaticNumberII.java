package LeetCode;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
 */


import java.util.LinkedList;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int m, int n) {
        List<String> rst = new LinkedList<>();
        if (m == 0) {
            rst.add("");
            return rst;
        }
        if (m == 1) {
            rst.add("0");
            rst.add("1");
            rst.add("8");
            return rst;
        }
        List<String> l = helper(m - 2, n);
        for (String s : l) {
            if (m != n) {
                rst.add("0" + s + "0");
            }
            rst.add("1" + s + "1");
            rst.add("6" + s + "9");
            rst.add("8" + s + "8");
            rst.add("9" + s + "6");
        }
        return rst;

    }


    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        StrobogrammaticNumberII solu = new StrobogrammaticNumberII();
        System.out.println(solu.findStrobogrammatic(2));
        System.out.println(solu.findStrobogrammatic(3));
        System.out.println(solu.findStrobogrammatic(4));
    }
}
