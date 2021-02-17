class MyHashSet {
    boolean[][] hashSet;
    int buckets;
    int bucketList;
    /** Initialize your data structure here. */
    private int findBucket(int key) {
        return key % buckets;
    }
    private int findBucketList(int key) {
        return key / bucketList;
    }
    public MyHashSet() {
        buckets = 5000;
        bucketList = 1001;
        hashSet = new boolean[buckets][];

    }

    public void add(int key) {
        int bucket = findBucket(key);
        int bucketItem = findBucketList(key);
        if (hashSet[bucket] == null) {
            hashSet[bucket] = new boolean[bucketList];
        }
        hashSet[bucket][bucketItem] = true;

    }

    public void remove(int key) {
        int bucket = findBucket(key);
        int bucketItem = findBucketList(key);
        if (hashSet[bucket] == null) return;

        hashSet[bucket][bucketItem] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = findBucket(key);
        int bucketItem = findBucketList(key);
        if (hashSet[bucket] == null) return false;

        return hashSet[bucket][bucketItem] ;
    }
}