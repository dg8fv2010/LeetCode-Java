package LeetCode;

/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,4,6].
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    List<Integer> rst;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.rst = new LinkedList<>();
        for (NestedInteger n : nestedList) {
            List<Integer> l = dfs(n);
            this.rst.addAll(l);
        }
    }

    public List<Integer> dfs(NestedInteger n) {
        List<Integer> l = new LinkedList<>();
        if (n.isInteger()) {
            l.add(n.getInteger());
            return l;
        }

        List<NestedInteger> list = n.getList();
        for (NestedInteger i : list) {
            l.addAll(dfs(i));
        }
        return l;
    }

    @Override
    public Integer next() {
        int num = this.rst.get(0);
        this.rst.remove(0);
        return num;
    }

    @Override
    public boolean hasNext() {
        return this.rst.size() > 0;
    }
}
