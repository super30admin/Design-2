// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : as this is a hash map and I am storing only values. The range of the value contains 0 as well. The secondary array gets initialized with 0's.
// had to handle the edge cases.


// Your code here along with comments explaining your approach
// used the double hashing technique to store the hash Map. 



class MyHashMap {
    private int primary;
    private int secondary;
    private int[][] storage;

    public MyHashMap() {
        this.primary=1000;
        this.secondary=1000;
        this.storage= new int[primary][];    
    }

    public int hash1(int key)
    {
        return key%primary;
    }
    
    public int hash2(int key)
    {
        return key/secondary;
    }
    public void put(int key, int value) {
        int primaryIndex = hash1(key);
        int secondaryIndex = hash2(key);
        if(storage[primaryIndex]==null)
        {
            if(primaryIndex==0)
            {
                storage[primaryIndex] = new int[secondary+1];
               // Arrays.fill(storage[primaryIndex], -1);
            }
            else 
            {
                storage[primaryIndex] = new int[secondary];
                // Arrays.fill(storage[primaryIndex], -1);
            }
        }
        if(value!=0)
            storage[primaryIndex][secondaryIndex]=value;
        else 
            storage[primaryIndex][secondaryIndex]=Integer.MIN_VALUE;
    }
    
    public int get(int key) {
        int primaryIndex = hash1(key);
        int secondaryIndex = hash2(key);
        if(storage[primaryIndex]==null) return -1;
        if(storage[primaryIndex][secondaryIndex] ==0) return -1;
        else if(storage[primaryIndex][secondaryIndex] ==Integer.MIN_VALUE) return 0;
        else 
            return storage[primaryIndex][secondaryIndex];
    }
    
    public void remove(int key) {
        int primaryIndex = hash1(key);
        int secondaryIndex = hash2(key);
        if(storage[primaryIndex]==null) return;
        storage[primaryIndex][secondaryIndex]=-1;        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */