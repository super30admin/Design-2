// Time Complexity : put: O(1), get: O(1), remove: O(1)
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Description:
// - Uses a 2D array as a hash table with two-level hashing.
// - The first hash selects a primary bucket, and the second hash selects an index within that bucket.
// - Buckets are created only when needed, allowing direct access to values in constant time.

class MyHashMap {
    private static final int PRIMARY_BUCKET_SIZE = 1000;
    private static final int SECONDARY_BUCKET_SIZE = 1000;

    private final int[][] primaryBuckets;

    public MyHashMap() {
        this.primaryBuckets = new int[PRIMARY_BUCKET_SIZE][];
    }

    public void put(int key, int value) {
        int primaryHash = getPrimaryHash(key);
        if(this.primaryBuckets[primaryHash] == null) {
            int secondaryBucketSize = SECONDARY_BUCKET_SIZE;
            if(primaryHash == 0) {
                secondaryBucketSize += 1;
            }
            this.primaryBuckets[primaryHash] = new int[secondaryBucketSize];
            Arrays.fill(this.primaryBuckets[primaryHash], -1);
        }
        int secondaryHash = getSecondaryHash(key);
        this.primaryBuckets[primaryHash][secondaryHash] = value;
    }

    public int get(int key) {
        int primaryHash = getPrimaryHash(key);
        if(this.primaryBuckets[primaryHash] == null) {
            return -1;
        }
        int secondaryHash = getSecondaryHash(key);

        return this.primaryBuckets[primaryHash][secondaryHash];
    }

    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if(this.primaryBuckets[primaryHash] == null) {
            return;
        }

        int secondaryHash = getSecondaryHash(key);

        this.primaryBuckets[primaryHash][secondaryHash] = -1;
    }

    private int getPrimaryHash(int key) {
        return key % PRIMARY_BUCKET_SIZE;
    }

    private int getSecondaryHash(int key) {
        return key / SECONDARY_BUCKET_SIZE;
    }
}