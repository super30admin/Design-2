public class MyHashMap2 {
		
    int buckets;
    int bucketItems;
    int[][] storage;

    public MyHashMap2() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new int[bucketItems + 1];
                for (int i = 0; i < storage[bucket].length; i++) {
                	storage[bucket][i] = -1;
                }
            } else {
                storage[bucket] = new int[bucketItems + 1];
                for (int i = 0; i < storage[bucket].length; i++) {
                	storage[bucket][i] = -1;
                }
            }
        }
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return -1;
       
        else
            return storage[bucket][bucketItem];
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return;
        else
            storage[bucket][bucketItem] = -1;
    }

    int getBucket(int key) {
        return key % buckets;
    }

    int getBucketItem(int key) {
        return key / bucketItems;
    }

	}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */