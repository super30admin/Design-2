// Time Complexity : O(1) for put, O(1) for get and remove
// Space Complexity : O(n) where n is the number of key-value pairs in the hash map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// this approach initializes an array of size 1000001 to store the values, 
// which may not be the most space-efficient solution if the number of key-value pairs is small. 
// However, it provides O(1) time complexity for put, get, and remove operations.


// This approach uses a simple array to implement the hash map. 
// We initialize an array of size 1000001 to store the values, 
// and fill it with -1 to indicate that the key is not present. 
// The put method updates the value at the index corresponding to the key, 
// the get method returns the value at the index corresponding to the

import java.util.Arrays;

class MyHashMap {
    int[] map;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}