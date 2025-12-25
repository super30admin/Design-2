
//Time Complexity O(1)
//Space Complexity O(n)

public class MyHashMap {

    private final int primaryBuckets;
    private final int secondaryBuckets;
    private final int[][] storage; 

    public MyHashMap() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new int[primaryBuckets][];
    }

    private int getPrimaryHash(int key) {
        return key % primaryBuckets; 
    }

    private int getSecondaryHash(int key) {
        return key / secondaryBuckets;
    }

    public void put(int key, int value) {
        int p = getPrimaryHash(key);
        if (storage[p] == null) {
            int length = (p == 0) ? secondaryBuckets + 1 : secondaryBuckets; 
            storage[p] = new int[length];
            for (int i = 0; i < length; i++) storage[p][i] = -1;
        }
        int s = getSecondaryHash(key);
        storage[p][s] = value;
    }

    public int get(int key) {
        int p = getPrimaryHash(key);
        int[] bucket = storage[p];
        if (bucket == null) return -1; 
        int s = getSecondaryHash(key);
        return bucket[s];
    }

    public void remove(int key) {
        int p = getPrimaryHash(key);
        int[] bucket = storage[p];
        if (bucket == null) return;
        int s = getSecondaryHash(key);
        bucket[s] = -1;
    }
}
