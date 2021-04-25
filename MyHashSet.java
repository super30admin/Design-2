class MyHashSet {

    /** Initialize your data structure here. */
    
    boolean [][]arr;
    int bucketSize,bucketList;
    public MyHashSet() {
        bucketSize = 1000;
        bucketList = 1001;
        arr = new boolean[bucketSize][];        
    }
    
    int hash1(int key){
        return key % bucketSize;
    }
    int hash2(int key){
        return key / bucketList;
    }
    public void add(int key) {
        int bucketLoc = hash1(key);
        int bucketListLoc = hash2(key);
        if(arr[bucketLoc] == null){
            arr[bucketLoc] = new boolean[bucketList];
        }
        arr[bucketLoc][bucketListLoc] = true;
    }
    
    public void remove(int key) {
        int bucketLoc = hash1(key);
        int bucketListLoc = hash2(key);
        if(arr[bucketLoc] == null){
            return;
        }
        arr[bucketLoc][bucketListLoc] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int bucketLoc = hash1(key);
        int bucketListLoc = hash2(key);
        if(arr[bucketLoc] == null){
            return false;
        }
         return arr[bucketLoc][bucketListLoc] ;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
