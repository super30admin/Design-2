// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    int bucket;
    int bucketItems;
    
    boolean[][] storage;

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000;
        bucketItems = 1001;
        storage = new boolean[bucket][];
    }
    
    private int hash1(int key) {
        return key % bucket;
    }
    
    private int hash2(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int row = hash1(key);
        if(null == storage[row]) {
            storage[row] = new boolean[bucketItems];
        }
        int column = hash2(key);
        storage[row][column] = true;
    }
    
    public void remove(int key) {
        int row = hash1(key);
        if(null == storage[row]) {
            return;
        }
        int column = hash2(key);
        if(storage[row][column]) {
            storage[row][column] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int row = hash1(key);
        if( null == storage[row]) {
            return false;
        }
        int column = hash2(key);
        return storage[row][column];
    }
}