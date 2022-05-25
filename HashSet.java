/*
// Time Complexity : o(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :No


*/class MyHashSet {
    private boolean [][] storage;
    int buckets; //primary array
    int bucketItems ; // nested array
    public MyHashSet() {
        buckets = 1000;
        bucketItems= 1000;
        storage = new boolean[buckets][bucketItems]; //don;t declare bucketItem  it will be initialed if we need nested array
    }
    public int bucket(int key){
        return key%buckets;
    }
    public int bucketItem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItem+1];
            }else{
                storage[bucket] = new boolean[bucketItem];
            }
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            return;
        }else{
            storage[bucket][bucketItem] = false;
        }    
        
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
         if(storage[bucket] == null) return false;
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
