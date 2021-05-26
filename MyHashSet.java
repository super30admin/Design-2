class MyHashSet {
    
    boolean[][] storage;
    int buckets;
    int bucketItems;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[1000][];
        buckets = 1000;
        bucketItems = 1000;
    }
    
    //hash1 fucntion
    public int hashBucket(int key) {
        return key%buckets;
    }
    
    //hash 2 function
    public int hashBucketItem(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = hashBucket(key);
        int bucketItem = hashBucketItem(key);

        if (storage[bucket] == null) {
            storage[bucket] = new boolean[bucketItems];
        }
        
        if (bucket == 0) {
            storage[bucket][bucketItem+1] = true;
        } else {
            storage[bucket][bucketItem] = true;
        }
    }
    
    public void remove(int key) {
        int bucket = hashBucket(key);
        int bucketItem = hashBucketItem(key);
        
        if (storage[bucket] == null) return;
        
         storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = hashBucket(key);
        int bucketItem = hashBucketItem(key);

        if (storage[bucket] == null) return false;

        return storage[bucket][bucketItem];       
        }

        public static void main(String[] args) {
            MyHashSet obj = new MyHashSet();
            obj.add(1);
            obj.add(2);
            obj.add(3);
            obj.remove(2);
            System.out.println("Contains 3? " + obj.contains(3));
            System.out.println("Contains 1? " + obj.contains(1));
            System.out.println("Contains 2? " + obj.contains(2));
        }
}
