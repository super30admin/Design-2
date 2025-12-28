// Using double hashing

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// I am using double hashing to handle collisions.
// The hash function is designed to distribute keys evenly across the buckets, reducing the likelihood of collisions.
// When a collision occurs, the second hash function is used to determine the bucket item index, further reducing the
// chance of collisions within the same bucket.
// Also, I am using wrapper class Integer instead of primitive int to handle null values, which is necessary for collision resolution.
// And returing the -1 if key is not found in get method. As int would have default value of 0.


class MyHashMap {

    Integer [][] storage;
    int buckets;
    int bucketItems;

    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new Integer[buckets][];
    }

    private int hash1(int key){
        return key % buckets;
    }
    private int hash2(int key){
        return key / buckets;
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public void put(int key, int value) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new Integer[bucketItems + 1];
            }else{
                storage[bucket] = new Integer[bucketItems];
            }

        }
        storage[bucket][bucketItem] = value;
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null || storage[bucket][bucketItem] == null) return -1;
        return storage[bucket][bucketItem];
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null || storage[bucket][bucketItem] == null) return;
        storage[bucket][bucketItem] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */