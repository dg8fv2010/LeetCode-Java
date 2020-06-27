package LeetCode;

import java.util.Arrays;

/*
There are 2N people a company is planning to interview.
The cost of flying the i-th person to city A is costs[i][0],
and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.



Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.


Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000
 */

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        // 计算到A的花费和到B的花费的差值，并排序
        // 差值越小，表明去A越便宜
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int rst = 0;
        int n = costs.length;
        for (int i = 0; i < n / 2; i++) {
            rst += costs[i][0];
        }
        for (int i = n / 2; i < n; i++) {
            rst += costs[i][1];
        }
        return rst;
    }
}
