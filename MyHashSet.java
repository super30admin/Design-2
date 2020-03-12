// Time Complexity : add O(1) remove O(1) contains O(1)
// Space Complexity : O(n) for number of elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class MyHashSet {

    private int bucket = 1000;
    private int bucketItem = 1000;
    boolean[][] storage = new boolean[bucket][];
    
    private int bucket(int key){
        return key%bucket;
    }
    
    private int bucketItem(int key){
        return key/bucketItem;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int rowIdx = bucket(key);
        int colIdx = bucketItem(key);
        if(storage[rowIdx] == null){
            storage[rowIdx] = new boolean[bucketItem];
        }
        storage[rowIdx][colIdx] = true;
    }
    
    public void remove(int key) {        
        int rowIdx = bucket(key);
        int colIdx = bucketItem(key);
        if(storage[rowIdx] != null){
            storage[rowIdx][colIdx] = false;
        }    
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int rowIdx = bucket(key);
        int colIdx = bucketItem(key);
        if(storage[rowIdx] != null){
            return storage[rowIdx][colIdx];
        }else{
            return false;
        }            
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */