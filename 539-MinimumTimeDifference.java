package LeetCode;

/*
Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
 */


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinimumTimeDifference {
    // 这个非常慢
    public int findMinDifference(List<String> timePoints) {
        List<Integer> t = new LinkedList<>();
        for (String s : timePoints) {
            int h = Integer.parseInt(s.split(":")[0]);
            int m = Integer.parseInt(s.split(":")[1]);
            t.add(h * 60 + m);
        }
        Collections.sort(t);
        int rst = 24 * 60;
        for (int i = 1; i < t.size(); i++) {
            rst = Math.min(rst, t.get(i) - t.get(i - 1));
        }
        rst = Math.min(rst, t.get(0) + 24 * 60 - t.get(t.size() - 1));
        return rst;
    }

    public int findMinDifference1(List<String> timePoints) {
        Collections.sort(timePoints);
        int rst = 24 * 60;
        for (int i = 1; i < timePoints.size(); i++) {
            int dif = sub_time(timePoints.get(i), timePoints.get(i - 1));
            int dif2 = Math.abs(24 * 60 - dif);
            rst = Math.min(rst, Math.min(dif, dif2));
        }

        if (timePoints.size() > 1) {
            int dif = sub_time(timePoints.get(timePoints.size() - 1), timePoints.get(0));
            int dif2 = Math.abs(24 * 60 - dif);
            rst = Math.min(rst, Math.min(dif, dif2));
        }
        return rst;
    }

    public int sub_time(String t1, String t2) {
        int h1 = Integer.parseInt(t1.split(":")[0]);
        int m1 = Integer.parseInt(t1.split(":")[1]);
        int h2 = Integer.parseInt(t2.split(":")[0]);
        int m2 = Integer.parseInt(t2.split(":")[1]);

        int dif_m = m1 - m2;
        if (dif_m < 0) {
            dif_m += 60;
            h1--;
        }
        int dif_h = h1 - h2;
        return dif_h * 60 + dif_m;
    }

    public static void main(String[] args) {
        testcase1();
    }

    public static void testcase1() {
        MinimumTimeDifference solu = new MinimumTimeDifference();
        List<String> l = new LinkedList<>();
        //l.add("00:00");
        l.add("23:59");
        l.add("00:00");
        System.out.println(solu.findMinDifference(l));
    }
}
