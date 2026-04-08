// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

import java.util.Arrays;
class MyHashMap {

    int[] hashstorage = new int[1000001];
    
    public MyHashMap() {
        Arrays.fill(hashstorage, -1);
    }
    
    public void put(int key, int value) {
        hashstorage[key] = value;
    }
    
    public int get(int key) {
        return hashstorage[key];
    }
    
    public void remove(int key) {
        hashstorage[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */