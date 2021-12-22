// Time Complexity : add = O(1)
//                   remove = O(1)
//                   contains = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[1000][];
    }

    private int bucket(int key)
    {
        return key%buckets;
    }
    private int bucketItem(int key)
    {
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null)
        {
            if(bucket == 0)
            {
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null)
        {
            return ;
        }
        storage[bucket][bucketItem] = false;

    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]== null)
        {
            return false;
        }
        return storage[bucket][bucketItem] ;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */