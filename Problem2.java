// Time Complexity :O(n), where n is the number of keys
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;

// code implements a basic key-value storage using two ArrayLists in Java,
// allowing insertion, retrieval, and removal of key-value pairs and key are stored in one list and values are stored in other list
class Problem2 {
    private static ArrayList<Integer> keys, values;

    public Problem2() {
        keys = new ArrayList<Integer>();
        values = new ArrayList<Integer>();
    }
    public void put(int key, int value) {
        int i;
        if((i = keys.indexOf(key)) != -1)
            values.set(i, value);
        else{
            keys.add(key);
            values.add(value);
        }
    }
    public int get(int key) {
        int i;
        if((i = keys.indexOf(key)) != -1)
            return values.get(i);
        return -1;
    }
    public void remove(int key) {
        int i = keys.indexOf(key);
        if(i != -1){
            keys.remove(i);
            values.remove(i);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */