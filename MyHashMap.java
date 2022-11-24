// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* 
 * To store the key we use a array, whose index is pointing to another array.
 * To avoid collision we are using hasing method for primary array using % and for secondary array using /
 * check for all the null pointer exceptions
 */
class MyHashMap {

    // array to store the values index wise and by doing hash - Double hashing
    // method
    private Integer[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashMap() {
        // generating squareroot of the total size of the keys, 1000000 --> 1000 buckets
        // and 1000 bucket items per bucket.
        buckets = 1000;
        bucketItems = 1000;
        storage = new Integer[buckets][];
    }

    // hashing key for the primary array by taking modulus
    public int hash1(int key) {
        return key % buckets;
    }

    // hashing key for the secondary array by taking / , since we have tp avoid the
    // collision again in secondary array.
    public int hash2(int key) {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        // generate index for bucket
        int bucket = hash1(key);
        // generate index for nested array
        int bucketItem = hash2(key);

        // checking if the primary array is null , if so check the index value, if the
        // index is 0, we add 1 element extra to avaoid nested collision.
        // or else just create a boolan array of length 1000
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new Integer[bucketItems + 1];
            } else {
                storage[bucket] = new Integer[bucketItems];
            }
        }
        // just set the value at that index.
        storage[bucket][bucketItem] = value;
    }

    public int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        // check to avoid null pointer exception
        if (storage[bucket] == null)
            return -1;

        // check to avoid null pointer exception
        if (storage[bucket][bucketItem] == null)
            return -1;
        return storage[bucket][bucketItem];

    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] == null)
            return;

        // remove the element at the index generated and set it to null
        storage[bucket][bucketItem] = null;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */