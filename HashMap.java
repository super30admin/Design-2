// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// To implement a HashMap, the most important point was to avoid duplicates with keys. 
// Which means, no hash collision.
// Total capacity of HashSet is 1000000, so First hashing is 1000 (sqrt of total capacity) 
// and second hashing is 1000 (remaining) which makes it a 2D Array and I am storing only the value 
// corrosponding to the location calculated by key.
// Challenge was to decide the data type of storage array if both key and value is to be stored.  

class MyHashMap {
    int buckets, bucketItems;
    int [][] storage;
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }

    int getBucket(int key) {
        return key % 1000;
    }

    int getBucketItem(int key) {
        return key / 1000;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            if(bucket == 0) storage[bucket] = new int[bucketItems+1];
            storage[bucket] = new int[bucketItems];
        }
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) return -1;
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */