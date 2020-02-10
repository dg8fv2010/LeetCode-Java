package LeetCode;

/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);
hashSet.contains(2);    // returns true
hashSet.remove(2);
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
 */

import java.util.Arrays;
import java.util.LinkedList;

public class DesignHashSet {
    LinkedList<boolean[]> list;

    /**
     * Initialize your data structure here.
     */
    public DesignHashSet() {
        this.list = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            boolean[] array = new boolean[1001];
            Arrays.fill(array, 0, 1000, false);
            this.list.add(array);
        }
    }

    public void add(int key) {
        int hashkey = key % 1000;
        this.list.get(hashkey)[key / 1000] = true;
    }

    public void remove(int key) {
        int hashkey = key % 1000;
        this.list.get(hashkey)[key / 1000] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hashkey = key % 1000;
        if (this.list.get(hashkey) != null) {
            return this.list.get(hashkey)[key / 1000];
        }
        return false;
    }

    public static void testcase1() {
        boolean a = false;
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(1);
        hashSet.add(2);
        a = hashSet.contains(1);    // returns true
        a = hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        a = hashSet.contains(2);    // returns true
        hashSet.remove(2);
        a = hashSet.contains(2);    // returns false (already removed)

        //RotateList solu = new RotateList();
        //solu.rotateRight(n1, 1);
        //System.out.println("1:" + solu.rotateRight(n1));
    }

    public static void main(String[] args) {
        testcase1();
    }

}
