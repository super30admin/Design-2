// Time Complexity :  add()-O(1), contains()-O(1), remove()-O(1)
// Space Complexity : O(n) where n is the 10^6 here or maximum number of input possible
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashSet {

    boolean[][] set;
    int bucket, bucketItem;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.bucket = 1000;
        this.set = new boolean[this.bucket][];
    }

    public int hash1(int key){
        return key%1000;
    }

    public int hash2(int key){
        return key/1000;
    }

    public void add(int key) {

        int bucket = this.hash1(key);
        if(this.set[bucket]==null){
            this.bucketItem = 1001;
            this.set[bucket] = new boolean[this.bucketItem];
        }
        int bucketItem = this.hash2(key);
        this.set[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = this.hash1(key);
        if(this.set[bucket]==null){
            return;
        }
        int bucketItem = this.hash2(key);
        this.set[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = this.hash1(key);
        if(this.set[bucket]==null){
            return false;
        }
        int bucketItem = this.hash2(key);
        return this.set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */