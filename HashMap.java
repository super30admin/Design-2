// Time Complexity : O(1)
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyHashMap {
    int primaryArray;
    int secondaryArray;
    int[][] storage;

    public MyHashMap() {
        this.primaryArray = 1000;
        this.secondaryArray = 1000;
        this.storage = new int[primaryArray][];
    }

    private int getPrimaryHash(int key){
        return key % primaryArray;
    }

    private int getSecondaryHash(int key){
        return key / secondaryArray;
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex == 0){
                storage[primaryIndex] = new int[secondaryArray+1];
            }else{
                storage[primaryIndex] = new int[secondaryArray];
            }
            Arrays.fill(storage[primaryIndex], -1);
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = value;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = -1;
    }

    public int get(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return -1;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}