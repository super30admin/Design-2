//Double hashing
// Time Complexity : O(1)
// Space Complexity : O(1)
class MyHashMap {
    private int[][] storage;
    private int buckets = 1000;
    private int bucketItems = 1000;
    public MyHashMap() {
        storage = new int[buckets][];
    }
    private int hash1(int key){
        return key % buckets;
    }
    private int hash2(int key){
        return key / bucketItems;
    }
    public void put(int key, int value) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new int[bucketItems+1];
            }else{
                storage[bucket] = new int[bucketItems];
            }
        }
        storage[bucket][bucketItem] = value+1;
    }
    
    public int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            return -1;
        }else if(storage[bucket][bucketItem] == -1) {
        	return storage[bucket][bucketItem];
        }
        return storage[bucket][bucketItem]-1;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = -1;
    }
}
