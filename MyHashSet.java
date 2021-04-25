package Hashset;

/*S30 Big N Problem #4 {Easy}

Implement HashSet without using any built-in libraries.

your design should include these functions:

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
Source Link: https://leetcode.com/problems/design-hashset/
*/
public class MyHashSet {
    boolean[][] storage = null;
    int buckets;
    int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {

        int buckets = 1000;
        int bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        if (storage[bucket(key)] == null) {
            storage[bucket(key)] = new boolean[bucketItems];
        }
        storage[bucket(key)][bucketItem(key)] = true;
    }

    public void remove(int key) {
        if (contains(key)) {
            storage[bucket(key)][bucketItem(key)] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        if (storage[bucket(key)] == null) {
            return false;
        }
        return storage[bucket(key)][bucketItem(key)];
    }

}
