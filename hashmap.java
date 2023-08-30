// Time Complexity : O(1)
// Space Complexity : O(1)

class MyHashMap {
    int buckets;
    int bucketItems;
    int[][] storage;
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }

    private int getBucket(int num) {
        return num % buckets;
    }

    private int getBucketItem(int num) {
        return num / buckets;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if(bucket == 0){
                storage[bucket] = new int[bucketItems + 1];
            } else {
                storage[bucket] = new int[bucketItems];
            }
            Arrays.fill(storage[bucket], -1);
        }
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]!= null) {
            return storage[bucket][bucketItem];
        } else return -1;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket]== null) {
            return;
        } else {
            storage[bucket][bucketItem] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
