// Time Complexity :
// contains(): O(N); add(): O(N); remove: O(N)

// Space Complexity :
// O(N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.List;

/**
 * Unique value in a hashSet
 *
 * @param <V> value
 */
class HashKey<V> {
    public V value;

    public HashKey(V value) {
        this.value = value;
    }
}

class MyHashSet {
    List<HashKey<Integer>> hashSet;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.hashSet = new LinkedList<HashKey<Integer>>();
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        for (HashKey<Integer> hashKey : this.hashSet) {     // Iterate over hashSet to find a key
            if (hashKey.value.equals(key))
                return true;
        }
        return false;
    }

    public void add(int key) {
        if (!contains(key)) {                               // If key doesn't exist, add it
            this.hashSet.add(new HashKey<Integer>(key));
        }
    }

    public void remove(int key) {
        for (HashKey<Integer> hashKey : this.hashSet) {
            if (hashKey.value.equals(key)) {
                this.hashSet.remove(hashKey);               // Remove a key if found
                break;
            }
        }
    }
}