// Time Complexity : O(1) for put, get, remove
// Space Complexity : O(n) / O(1000001) to initialize the arr to -1 for all the positions
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :  NO

class MyHashMap {
    int[] arr = new int[1000001];

    public MyHashMap() {
        int i = 0;
        while (i < arr.length) arr[i++] = -1;
    }
    
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    public int get(int key) {
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */