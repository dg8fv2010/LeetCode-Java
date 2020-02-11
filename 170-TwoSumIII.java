package LeetCode;

/*
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 */


import java.util.*;

class TwoSumIII2 {
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new LinkedList<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        for (Integer integer : this.list) {
            this.set.add(integer + number);
        }
        this.list.add(number);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        return this.set.contains(value);
    }
}


public class TwoSumIII {
    Map<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) {
            map.replace(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // 遍历map，t=val-key
    // 如果t==key，map中key对应的value要大于1，表示至少有两个相同的key
    // 如果t!=key，判断map中是否存在t
    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int t = value - entry.getKey();
            if ((t == entry.getKey() && entry.getValue() > 1) || (t != entry.getKey() && map.containsKey(t))) {
                return true;
            }
        }
        return false;
    }
}