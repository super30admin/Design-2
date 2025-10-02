/**
 * 1. Creating HashSet and use double hashing for resolving collisions.
 * 2. Use 3D square matrix/array for storing keys and values.
 */
class MyHashMap {

    private int bucketSize = 1000;
    private int[][][] buckets = new int[bucketSize][][];

    private int hash1(int key) {
        return key % bucketSize;
    }

    private int hash2(int key) {
        return key / bucketSize;
    }

    public MyHashMap() {
    }

    public void put(int key, int value) {
        if (buckets[hash1(key)] == null) {
            if (hash1(key) == 0)
                buckets[hash1(key)] = new int[bucketSize + 1][];
            else
                buckets[hash1(key)] = new int[bucketSize][];
        }
        if(buckets[hash1(key)][hash2(key)] == null)
            buckets[hash1(key)][hash2(key)] = new int[1];

        buckets[hash1(key)][hash2(key)][0] = value;

    }

    public int get(int key) {
        if (buckets[hash1(key)] == null || buckets[hash1(key)][hash2(key)] == null)
            return -1;
        return buckets[hash1(key)][hash2(key)][0];
    }

    public void remove(int key) {
        if (buckets[hash1(key)] == null || buckets[hash1(key)][hash2(key)] == null)
            return;
        buckets[hash1(key)][hash2(key)] = null;
    }
}
