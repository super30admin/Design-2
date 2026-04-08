
// Time Complexity : All Functions - put and remove - O(n) where n is the number of elements in the bucket, get - O(n) where n is the number of elements in the bucket
// Space Complexity : O(n) where n is the number of key-value pairs in the hash map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach : 
// I followed the same approach which we discussed in class for hash set, but here instead of just key we have key-value pair, so I created a class Entry to store the key-value pair and used the same approach as hashset to handle the collision.
// We will use the hash function to get the bucket index and then we will check if the key already exists in the bucket, if it does then we will update the value, if it does
// not then we will add a new entry to the bucket.
// For get and remove we will use the same approach to find the entry in the bucket and return the value or remove the entry from the bucket.

class MyHashMap2 {

    int primaryBuckets;
    int secondaryBuckets;
    Integer[][] storage;

    public MyHashMap2() {
       this.primaryBuckets=1000;
       this.secondaryBuckets=1000;

       this.storage=new Integer[primaryBuckets][];

    }

    private int getPrimaryHash(int key)
    {
        return key % primaryBuckets;
    }

    private int getsecondaryHash(int key)
    {
        return key/secondaryBuckets;
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHash(key);

        if(storage[primaryIndex]==null)
        {
            if(primaryIndex==0)
            {
                storage[primaryIndex]=new Integer[secondaryBuckets+1];

            }
            else
            {
                storage[primaryIndex] = new Integer[secondaryBuckets];
            }
        }
        int secondaryIndex=getsecondaryHash(key);
        storage[primaryIndex][secondaryIndex]=value;
    }

    public int get(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null)
        {
            return -1;
        }
        int secondaryIndex=getsecondaryHash(key);
        return storage[primaryIndex][secondaryIndex]!=null ? storage[primaryIndex][secondaryIndex] : -1;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = getsecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = null; // remove key
        }
    
}