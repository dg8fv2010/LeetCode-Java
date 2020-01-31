package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rst = new LinkedList<>();
        rst.add(1);
        int idx = 1;
        while (idx <= rowIndex) {
            int pos = 1;
            for (int cur = 1; cur < rst.size(); cur += 2) {
                rst.add(pos, rst.get(cur - 1) + rst.get(cur));
                pos++;
            }

            while (rst.size() > idx) {
                rst.remove(rst.size() - 1);
            }
            rst.add(rst.size(), 1);
            idx++;
        }

        return rst;
    }

    // 使用了O(k)的空间
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> rst = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            rst.add(0);
        }
        rst.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                int tmp = rst.get(j) + rst.get(j - 1);
                rst.set(j, tmp);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        PascalsTriangleII solu = new PascalsTriangleII();
        System.out.println("1:" + solu.getRow2(4));
    }
}
