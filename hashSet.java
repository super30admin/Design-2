// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class MyHashSet {
    boolean[][] hashset;
    int buckets = 1000;
    int bucketItems = 1001;
    
    public MyHashSet() {
         hashset = new boolean[buckets][];
    }
    
    private int getBucket(int key) {
        return key % buckets;
    }
    
    private int getBucketItem(int key) {
        return key / bucketItems;
    } 
    
    public void add(int key) {
        int bucketIndex = getBucket(key);
        int itemIndex = getBucketItem(key);
        
        if(hashset[bucketIndex] == null) {
            hashset[bucketIndex] = new boolean[bucketItems];     
        }
       
        hashset[bucketIndex][itemIndex] = true;
    }
    
    public void remove(int key) {
        int bucketIndex = getBucket(key);
        int itemIndex = getBucketItem(key);
        
        if (hashset[bucketIndex] != null && hashset[bucketIndex][itemIndex] == true) {
            hashset[bucketIndex][itemIndex] = false;
        } 
    }
    
    public boolean contains(int key) {
         int bucketIndex = getBucket(key);
        int itemIndex = getBucketItem(key);
        
        if (hashset[bucketIndex] == null)
            return false;
        
        if (hashset[bucketIndex] != null && hashset[bucketIndex][itemIndex] == true) {
            return true;
        }  else {
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

