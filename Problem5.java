// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    int[] map;
    boolean[] exists;

    public MyHashMap() {
        map = new int[1000001];
        exists = new boolean[1000001];
    }
    
    public void put(int key, int value) {
        map[key] = value;
        exists[key] = true;
    }
    
    public int get(int key) {
        if (exists[key]) {
            return map[key];
        }
        return -1;
        
    }
    
    public void remove(int key) {
        exists[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */