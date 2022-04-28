class HashSet{
    private boolean[][] storage;
    private final int BUCKETS;
    private final int BUCKET_ITEMS;

    public MyHashSet(){
        BUCKETS = 1000;
        BUCKET_ITEMS = 1000;
        this.storage = new boolean[BUCKETS][];
    }

    // first hash function
    private int bucketHash(int key){
        return key % BUCKETS;
    }

    // second hash function
    private int bucketItemsHash(int key){
        return key / BUCKET_ITEMS;
    }
    
    public void add(int key){
        int bucket = bucketHash(key);
        int bucketItem = bucketItemsHash(key);
        if(storage[bucket] == null){
            if(bucket == 0) 
                storage[bucket] = new boolean[BUCKET_ITEMS + 1];
            else
                storage[bucket] = new boolean[BUCKET_ITEMS];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public boolean contains(int key){
        int bucket = bucketHash(key);
        int bucketItem = bucketItemsHash(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key){
        int bucket = bucketHash(key);
        int bucketItem = bucketItemsHash(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        
    }
}
