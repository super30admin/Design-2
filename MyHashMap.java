// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Approach:
// Use two-level indexing with primary and secondary hashing.
// Store values in a 2D array and use -1 to represent missing keys.

class MyHashMap {
    int primaryBuckets;
    int secondaryBuckets;
    int[][] storage;

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
        int primaryIndex = getPrimaryHash(key);

        if (storage[primaryIndex] == null) {
            if (primaryIndex == 0) {
                storage[primaryIndex] = new int[secondaryBuckets + 1];
            } else {
                storage[primaryIndex] = new int[secondaryBuckets];
            }

            for (int i = 0; i < storage[primaryIndex].length; i++) {
                storage[primaryIndex][i] = -1;
            }
        }

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = value;
    }
    
    public int get(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return -1;
        }

        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return;
        }

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = -1;
    }
}
