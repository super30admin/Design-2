// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashMap {

    // Decisions
    // Size - always prefer square root. here 1000000 --> 1000
    // Datastructure - boolean square matrix can work here

    int [][]storage;
    int buckets; // horizantal bucket
    int bucketItems; // vertical bucket

    public MyHashMap() {
        this.buckets =  1000;
        this.bucketItems = 1000; // 1000 here is sqrt size
        this.storage = new int[1000][];
    }

    public int hash1(int key){
        return key%buckets;
    }

    public int hash2(int key){
        return key/bucketItems;
    }

    public void put(int key, int value) {
        int bucket = hash1(key);
        if(storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new int[bucketItems +1];
            } else {
                storage[bucket] = new int[bucketItems];

            }
        }

        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = value;

    }

    public int get(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) {
            return -1;
        } else {
            int bucketItem = hash2(key);
            return storage[bucket][bucketItem];

        }
    }

    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) {
            return;
        } else {
            int bucketItem = hash2(key);
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