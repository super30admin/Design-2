// Time Complexity :
// add, remove, contians:O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyHashSet {
    
    // member variables
    private boolean[][] hashSet;
    private int capacity =1000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[capacity][];
    }
    
     /** adds specified element */
    public void add(int key) {

        // getting bucket id and Bucket item id
        int bucketId = getBucketId(key);
        int bucketItemId = getBucketItemId(key);

        // check if array initialized
        if(hashSet[bucketId] == null)
            hashSet[bucketId] = new boolean[capacity];

        hashSet[bucketId][bucketItemId] = true;
    }

    /** removes if this set contains the specified element */
    public void remove(int key) {

        // getting bucket id and Bucket item id
        int bucketId = getBucketId(key);
        int bucketItemId = getBucketItemId(key);

        // check if array initialized and element is present
        if(hashSet[bucketId] != null && hashSet[bucketId][bucketItemId] )
            hashSet[bucketId][bucketItemId] = false;
    }
    
    /** Returns bucket hash function*/
    private int getBucketId(int key){
        return key%capacity;
    }
    
    /** Returns bucket Item hash function */
    private int getBucketItemId(int key){
        return key/capacity;
    }
    
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        // getting bucket id and Bucket item id
        int bucketId = getBucketId(key);
        int bucketItemId = getBucketItemId(key);

        // check if array initialized and element present or not
        return hashSet[bucketId] != null && hashSet[bucketId][bucketItemId];
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        int x = 5, y = 10, z = 2;
        obj.add(x);
        obj.add(y);
        obj.add(z);
        System.out.println("Added: "+ x +", "+y+", "+z);
        obj.remove(y);
        System.out.println("Removed: "+ y);

        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */