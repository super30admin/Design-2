// Time Complexity : O(1)
// Space Complexity : O(1)(O(10000))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// I am taking 2 hashes on any given key value. The first hash is to find out the bucket where the (k,v) is to be placed and the second hash is to find the location within the bucket where the element is to be placed.
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1001;
        bucketItems = 1001;
        storage = new boolean[buckets][] ;
        
    }
    
    private int getBucket(int key){
        return key % buckets;
    }
    private int getBucketitem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketitem = getBucketitem(key);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketitem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketitem = getBucketitem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketitem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketitem = getBucketitem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketitem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
