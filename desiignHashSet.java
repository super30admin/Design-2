// Time Complexity : O(1)
// Space Complexity : O(n), where n is the number of elements the user puts.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[][] hashSet;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        hashSet = new boolean[1000][];
        //Length of the big array
        buckets = 1000;
        //Length of the small array inside the big array
        bucketItems = 1000;
    }
    
    //Hashing function to get index in the big array
    private int bucketHashFunction(int key) {
        return key % buckets;
    }
    
    //Hashing function to get index in the small array
    private int bucketItemsHashFunction(int key) {
        return key / buckets;
    }
    

    public void add(int key) {
        int bucket = bucketHashFunction(key);
        int bucketItem = bucketItemsHashFunction(key);
        //If the small array doesn't exist then create a array of size 'bucketItems' inside the biggerArray[bucket]
        if(hashSet[bucket] == null)
        {
            if(bucket == 0)
                hashSet[bucket] = new boolean[bucketItems+1];
            else
                hashSet[bucket] = new boolean[bucketItems];
        }
        
        hashSet[bucket][bucketItem] = true;
    }
    
    //Removing is to make that value false
    public void remove(int key) {
        int bucket = bucketHashFunction(key);
        int bucketItem = bucketItemsHashFunction(key);
        if(hashSet[bucket] == null) return;
        hashSet[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucketHashFunction(key);
        int bucketItem = bucketItemsHashFunction(key);
        if(hashSet[bucket] == null) return false;
        return hashSet[bucket][bucketItem];
    }
}