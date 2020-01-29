package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        if (numRows == 0) {
            return rst;
        }
        rst.add(new ArrayList<>(Arrays.asList(1)));
        int idx = 1;
        while (idx<numRows) {
            List<Integer> prev = rst.get(idx-1);
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int i=0;i<prev.size()-1;i++) {
                cur.add(prev.get(i)+prev.get(i+1));
            }
            cur.add(1);
            idx++;
            rst.add(cur);
        }
        return rst;
    }

    public static void main(String[] args) {
        PascalsTriangle solu = new PascalsTriangle();
        System.out.println("1:" + solu.generate(5));
    }
}
