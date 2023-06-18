/*
Author: Akhilesh Borgaonkar
Approach: I have implemented using arrays and double hashing method to avoid collisions. The boolean value is stored at the index key of the sub-array 
    which is nested in the parent array. I have two hashing functions, one generates index for parent array and another generates index for sub-array.
Time Complexity: O(1) for get(), put() and remove()
Space Complexity: O(n) where n is number of elements in the array.
LC verified
Scope of improvement: Going to try to use Arraylist<Integer>[] to reduce space.
*/

class MyHashSet {

    int buckets = 1000;
    int bucketItems = 1000;
    boolean[][] myHashset = new boolean[buckets][];     //my hashset to store boolean values to determine presence of integer in the hashset
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    private int getBucketIdx(int value){
        return value%buckets;                           //hashing function-1 to get index of parent array
    }
    
    private int getBucketItemIdx(int value){
        return value/buckets;                           //hashing function-2 to get index of sub array
    }
    
    public void add(int key) {
        int bucket = getBucketIdx(key);                 //getting the index of parent array
        int bucketList = getBucketItemIdx(key);         //getting the index of sub array
        
        if(myHashset[bucket] == null)
            myHashset[bucket] = new boolean[bucketItems];    //if the sub-array is never created then create it
        
        myHashset[bucket][bucketList] = true;           //marking the presence of this key in my hashset
    }
    
    public void remove(int key) {
        int bucket = getBucketIdx(key);
        int bucketList = getBucketItemIdx(key);
        
        if(myHashset[bucket] != null)
            myHashset[bucket][bucketList] = false;      //marking the location as false to state that this key is no more present
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucketIdx(key);
        int bucketList = getBucketItemIdx(key);
        
        return (myHashset[bucket] != null && myHashset[bucket][bucketList]);    //if the sub array is present and is true then key is present in my hashset
    }
}