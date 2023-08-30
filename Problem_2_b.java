/* 

Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Implementing by using double hashing and storing the value at the correct index. We use hashfunctions to determine 
the index of the primary array and the index in the secondary array and store the value in that particular location. This allows
us to compute in O(1) for get, remove and put function.
 
 */

 class MyHashMap {

    int Buckets;
    int BucketLists;
    Integer[][] arr;

    int getBucket(int key){
        return Integer.hashCode(key) % Buckets;
    }

    int getBucketList(int key){
        return Integer.hashCode(key) / BucketLists;
    }

    public MyHashMap() {
        Buckets = 1000;
        BucketLists = 1000;
        arr = new Integer[Buckets][];
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketList = getBucketList(key);
        if(arr[bucket] == null){
            if(bucket == 0)
                arr[bucket] = new Integer[BucketLists + 1];
            else
                arr[bucket] = new Integer[BucketLists];
        }
        arr[bucket][bucketList] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketList = getBucketList(key);
        if(arr[bucket] == null){
           return -1;
        }
        if(arr[bucket][bucketList] == null){
            return -1;
        }
        return arr[bucket][bucketList];
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketList = getBucketList(key);
        if(arr[bucket] == null){
           return;
        }
        arr[bucket][bucketList] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */