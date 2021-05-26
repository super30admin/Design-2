//Time Complexity : O(1)
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;


    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    int bucket(int key){
        return key % buckets;
    }

    int bucketItem(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        //getting values to store in bucket
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
                storage[bucket] = new boolean[bucketItems+1];
                storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }

   
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(storage[bucket] == null)return false;

        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */