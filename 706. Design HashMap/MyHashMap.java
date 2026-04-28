import java.util.*;

class MyHashMap {

    int primaryBucket;
    int secondaryBucket;
    int[][] storage;

    public MyHashMap() {

        this.primaryBucket = 1000;
        this.secondaryBucket = 1000;
        this.storage = new int[primaryBucket +1][];

    }

    public int getPrimaryHash(int key) {

        return key / primaryBucket;

    }

    public int getSecondaryHash(int key) {

        return key % secondaryBucket;

    }

    public void put(int key, int value) {

        int primaryIndex = getPrimaryHash(key);

        if (storage[primaryIndex] == null) {
            if (primaryIndex == 0) {
                storage[primaryIndex] = new int[secondaryBucket + 1];
            } else {
                storage[primaryIndex] = new int[secondaryBucket];
            }
            Arrays.fill(storage[primaryIndex], -1);
        }

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = value;

    }

    public int get(int key) {

        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null)
            return -1;

        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];

    }

    public void remove(int key) {

        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null)
            return;

        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = -1;
    }
}

// TC - O(1)
// SC - O(10^6) //As it is demmand on allocation so actual is O(1)

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */