//Time Complexity: O(1)
//Space Complexity:O(n*1000)
class MyHashSet {   
    int buckets;
    int bucketItems;
    boolean[][] storage;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1001;
        storage = new boolean[buckets][];
    }
    public int getBucket(int key){
        return key%buckets;
    }
    public int getBucketItem(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */