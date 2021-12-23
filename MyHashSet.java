// Time Complexity :  O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    private int bucket;
    private int bucketItem;
    boolean [][] set;
    
    public int bucket(int key) {
        return key%bucket;
    }

    public int bucketItem(int key) {
        return key/bucketItem;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket = 1000;
        bucketItem = 1000;
        set = new boolean[bucket][];
    }
    
    public void add(int key) {
        int hash1 = this.bucket(key);
        int hash2 = this.bucketItem(key);
        if(set[hash1]==null) {
            if(hash1==0) {
                set[hash1] = new boolean[bucketItem+1];
            } else {
                set[hash1] = new boolean[bucketItem];
            }
        }
        set[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = this.bucket(key);
        int hash2 = this.bucketItem(key);
        if(set[hash1]==null) return;
        set[hash1][hash2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash1 = this.bucket(key);
        int hash2 = this.bucketItem(key);
        if(set[hash1]==null) return false;
        return set[hash1][hash2];
    }
}
