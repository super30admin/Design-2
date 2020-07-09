// Approach
// 1. maintian a primary array of size 1000 and secodndary arrays of size 1000
// 2. use 2 hash functions so that contains() operation takes O(1) time
// 3. by using 1000*1000 2d array there is no chance for collisions


// Time Complexity : add - O(1) , remove - O(1), contains - O(1)
// Space Complexity : 
// Did this code successfully run on Leetcode : yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    int buckets = 1000;
    int itemsInBuckets=1000;
    boolean[][] container=new boolean[buckets][];
    
    int getBucket(int key){
        return key%buckets;
    }
    
    int getBucketItems(int key){
        return key/buckets;
    }
    
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if (container[bucket]==null){
            container[bucket] = new boolean[itemsInBuckets];
        }
        container[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
         if (container[bucket]!=null){
            container[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        return container[bucket]!=null && container[bucket][bucketItem] != false;
          
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */