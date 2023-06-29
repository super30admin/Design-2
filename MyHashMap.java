
// Time Complexity : put, get and remove methods have time complexity of O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

    // The input range is 0 <= key, value <= 10^6
    // We must take care of the edge case 1000000

    int[] arr;

    public MyHashMap() {
        arr = new int[1000001];
        for(int i = 0; i < 1000001; i++)
        {
            arr[i] = -1;
        }
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