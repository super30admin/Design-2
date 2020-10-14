// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class MyHashSet {
    int bucket ;
    int bucketItems ; 
    boolean storage [][];
    /** Initialize your data structure here. */
    public MyHashSet() {
        // The range of array is 1000000 = 1000 X 1000 
        bucket = 1000;
        bucketItems = 1001; // need to consider 1000th element  as 1000000/1000 = 1000 for hash2 
        storage = new boolean[bucket][];
    }
    private int hash1(int key){
        return key%1000;
    }
    private int hash2(int key){
        return key/1000;
    }
    public void add(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(storage[index1]== null){
            storage[index1]= new boolean[bucketItems];
        }
        storage[index1][index2] = true;
    }
    
    public void remove(int key) {
         int index1 = hash1(key);
         int index2 = hash2(key);
         if(storage[index1] == null) return ; // the 2d grid is initialized as null and not false
         storage[index1][index2] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(storage[index1] == null) return false;
        return storage[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */