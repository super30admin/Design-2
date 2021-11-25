// Time Complexity : O (1) for all operations
// Space Complexity : O(1) as we do not consider the constructor for calculations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    // Approach Used:
    // Took a 2 D boolean array for storage
    // Took the sq rt of the maximum possible as the buckets
    // These buckets contains the address for the bucketItems which is the secondary
    // array with length sq rt of max val
    boolean[][] set;
    int buckets;
    int bucketItems;

    // Initialisation
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.set = new boolean[buckets][];
    }

    // when the key is added we do two hash functions to get the values of bucket
    // and bucket item
    // if the bucket is null, we create new secondary array
    // if bucket is 0, we create an array with bucketitems + 1, to account for 10^6
    // we put true in corresponding bucket and bucketitem
    public void add(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if (set[bucket] == null) {
            if (bucket == 0)
                set[bucket] = new boolean[bucketItems + 1];
            else
                set[bucket] = new boolean[bucketItems];
        }
        set[bucket][bucketItem] = true;
    }

    // To remove the key, we do two hash functions to get the values of bucket and
    // bucket item
    // When the bucket is not null, we put false in corresponding bucket and
    // bucketitem
    public void remove(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if (set[bucket] != null)
            set[bucket][bucketItem] = false;
    }

    // To get the key, we do two hash functions to get the values of bucket and
    // bucket item
    // if the bucket is null, we return false
    // otherwise we return the value corresponding bucket and bucketitem
    public boolean contains(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if (set[bucket] == null)
            return false;

        return set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */