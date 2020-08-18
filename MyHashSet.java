//Design Hashset
//Time Complexity: O(1) for all operations
//Space Complexity: O(n)

class MyHashSet {
    int buckets = 1000;
    int nestedBuckets = 1000;
    boolean[][] storage = new boolean[buckets][];

    public int bucket(int value){
        return (value % buckets);
    }

    public int bucketItem(int value){
        return (value / nestedBuckets);
    }
    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int value) {
        int bucket = bucket(value);
        int nestedBucket = bucketItem(value);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[nestedBuckets];
        }
        storage[bucket][nestedBucket] = true;
    }

    public void remove(int value) {
        int bucket = bucket(value);
        int nestedBucket = bucketItem(value);
        if(storage[bucket] != null && storage[bucket][nestedBucket])
            storage[bucket][nestedBucket] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int value) {
        int bucket = bucket(value);
        int nestedBucket = bucketItem(value);
        if(storage[bucket] != null && storage[bucket][nestedBucket])
            return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */