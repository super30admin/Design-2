class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] storage;
    int primaryStorage;
    int secondaryStorage;
    public MyHashSet() {
        primaryStorage = 1000;
        secondaryStorage = 1000;
        storage = new boolean[primaryStorage][];
    }
    private int getPrimaryIndex(int key)
    {
        return key%primaryStorage;
    }
    private int getSecondaryIndex(int key)
    {
        return key/secondaryStorage;
    }
    public void add(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(storage[primaryIndex]==null)
        {
            if(primaryIndex==0)
            {
               storage[primaryIndex] = new boolean[secondaryStorage+1]; 
            }
            else
            {
                storage[primaryIndex] = new boolean[secondaryStorage];
            }
        }
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(storage[primaryIndex]!=null)
        {
          storage[primaryIndex][secondaryIndex] = false;
        }
        return;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(storage[primaryIndex]!=null)
        {
          return storage[primaryIndex][secondaryIndex];
        }
        else
        {
            return false;
        }
    }
}
/*
    Time Complexity
    add - O(1)
    contains - O(1)
    remove - O(1)
    
    Space Complexity - O(primary array size * secondary array size)
    

*/
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */