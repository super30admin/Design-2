class MyHashSet {

    private boolean[][] store;
    int buckets,bucketItems;

    
    /** Initialize your data structure here. */
    MyHashSet() {
        store = new boolean[1000][];
        buckets = 1000;
        bucketItems = 1000;
    }
  
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    public void add(int key) {
      int bucket = bucket(key);
      int bucketItem = bucketItem(key);
        
      if(store[bucket]==null){
          if(bucket ==0){
              store[bucket] = new boolean[bucketItems+1];
          }
          else{
          store[bucket] = new boolean[bucketItems];
          }
      }
        store[bucket][bucketItem] = true;
    }

    public void remove(int key) {
      int bucket = bucket(key);
      int bucketItem = bucketItem(key);
      if(store[bucket]==null){
            return;
      }
       store[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       int bucket = bucket(key);
       int bucketItem = bucketItem(key);
      if(store[bucket]==null){
        return false;
      }       
        return store[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */