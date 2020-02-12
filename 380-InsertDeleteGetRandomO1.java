package LeetCode;

/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */

import java.util.*;

public class InsertDeleteGetRandomO1 {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) return false;
        this.list.add(val);
        if (!this.map.containsKey(val)) {
            this.map.put(val, this.list.size() - 1);
        }
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    // 现获取被删除元素的idx，并且将数组里面对应idx的值赋为数组最后一个元素的值，再删除最后一个元素
    // map里面先更新数组中最后一个元素的位置，再删除要删除的元素
    public boolean remove(int val) {
        if (!this.map.containsKey(val)) return false;
        int idx = this.map.get(val);
        int last_val = this.list.get(this.list.size() - 1);
        this.list.set(idx, last_val);
        this.list.remove(this.list.size() - 1);
        this.map.replace(last_val, idx);
        this.map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return this.list.get(this.random.nextInt(this.list.size()));
    }

    public static void testcase1() {
        InsertDeleteGetRandomO1 randomSet = new InsertDeleteGetRandomO1();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        boolean a = randomSet.insert(1);

        // Returns false as 2 does not exist in the set.
        a = randomSet.remove(2);

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        a = randomSet.insert(2);

        // getRandom should return either 1 or 2 randomly.
        int b = randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        a = randomSet.remove(1);

        // 2 was already in the set, so return false.
        a = randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        b = randomSet.getRandom();
    }

    public static void testcase2() {
        InsertDeleteGetRandomO1 randomSet = new InsertDeleteGetRandomO1();
        boolean a=false;
        int b=0;
        a=randomSet.remove(0);
        a=randomSet.remove(0);
        a=randomSet.insert(0);
        b=randomSet.getRandom();
        a=randomSet.remove(0);
        a=randomSet.insert(0);
    }

    public static void main(String[] args) {
        //testcase1();
        testcase2();
    }
}
