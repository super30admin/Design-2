// Time Complexity : O(1) where n is the size of the bucket
//    TC is amortized O(1) since we're filling each bucketItem array with -1 
//    using Arrays.fill() which takes O(n) for a max of sqrt(n) times (which is
//    our bucket array size)
// Space Complexity : O(n) where n is the total range of values supported
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * The hashing function used is a modulus operator (single hash function).
 * In case of collision, we use the method of double hashing which uses a 2D
 * array to store the buckets and each bucket item.
 */

import java.util.Arrays;

class MyHashMap {
    int[][] storage;
    int buckets;

    public MyHashMap() {
        buckets = 1000;
        storage = new int[buckets][];
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / buckets;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            if (bucket == 0) { // accommodate complete range
                storage[bucket] = new int[buckets+1];
            } else {
                storage[bucket] = new int[buckets];
            }
            // following is O(n), but won't happen more than buckets times
            // it is needed to convey the existence of a value
            Arrays.fill(storage[bucket], -1); 
        }
        int bucketItem = getBucketItem(key);
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return -1;
        }
        int bucketItem = getBucketItem(key);
        return storage[bucket][bucketItem]; // returns -1 if non-existent
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return;
        }
        int bucketItem = getBucketItem(key);
        storage[bucket][bucketItem] = -1; // equivalent of removing
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */