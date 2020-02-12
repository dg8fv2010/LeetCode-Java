package LeetCode;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

public class TopKFrequentElements {
    // 先用hashmap统计数字出现的次数
    // 再用堆按照出现次数排序，插入一个元素的时间复杂度为O(log(k))， n个元素为O(Nlog(k))
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int key:map.keySet()){
            heap.add(key);
            if (heap.size()>k) {
                heap.poll();
            }
        }

        List<Integer> rst = new LinkedList<>();
        while (!heap.isEmpty()) {
            rst.add(heap.poll());
        }
        Collections.reverse(rst);
        return rst;
    }

    public static void testcase1() {
        TopKFrequentElements solu = new TopKFrequentElements();
        System.out.println(solu.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public static void testcase2() {
        TopKFrequentElements solu = new TopKFrequentElements();
        System.out.println(solu.topKFrequent(new int[]{1, 2}, 2));
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }
}
