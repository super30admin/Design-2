// Time Complexity : O(1) for put (amortized), get, and remove operations. O(n) worst case for put if resizing is needed.
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I have used a 2D array and double hashing to store the key-value pairs. 
// The first dimension is based on the key modulo 1000, and the second dimension is based on the key divided by 1000.
// I initialize the 2D array with -1 to indicate empty slots since the values can be 0.

import java.util.Arrays;

class MyHashMap {

    private int[][] hashmap;
    
    public MyHashMap() {
        this.hashmap = new int[1000][];
    }
    
    public void put(int key, int value) {
        if (hashmap[key%1000] == null) {
            hashmap[key%1000] = (key%1000 == 0) ? new int[1001] : new int[1000];
            Arrays.fill(hashmap[key%1000], -1);
        }
        hashmap[key%1000][key/1000] = value;
    }
    
    public int get(int key) {
        return hashmap[key%1000]==null?-1:hashmap[key%1000][key/1000];
    }
    
    public void remove(int key) {
        if(hashmap[key%1000]==null) return;
        hashmap[key%1000][key/1000] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */