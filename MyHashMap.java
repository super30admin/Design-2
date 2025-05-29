import java.util.HashMap;
// Time Complexity :
// put(key, value)   => O(1) average, O(n) worst case due to rehashing
// get(key)          => O(1) average, O(n) worst case
// remove(key)       => O(1) average, O(n) worst case

// Space Complexity : O(n) — where n is the number of key-value pairs in the map
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
// - Initially had a NullPointerException when using hm.get(key) and returning it as an int.
//   Fixed it by replacing with getOrDefault(key, -1) to avoid unboxing null.

/*
Approach:
This is a wrapper around Java's built-in HashMap<Integer, Integer>. It provides methods to
put, get, and remove key-value pairs.

- `put(key, value)` simply adds or updates the key in the HashMap.
- `get(key)` returns the value if it exists; otherwise, returns -1 (avoiding NullPointerException).
- `remove(key)` removes the key from the map.
- The `toString()` override makes printing the current state of the map easy for debugging or visualization.

This implementation is mainly useful for educational purposes or to mock the interface of a custom-designed hashmap.
*/
class MyHashMap {
    HashMap<Integer,Integer> hm;


    public MyHashMap() {
        hm = new HashMap<>();
    }
    
    public void put(int key, int value) {
        hm.put(key, value);
        
    }
    
    public int get(int key) {
        return hm.getOrDefault(key, -1);
    }
    
    public void remove(int key) {
        hm.remove(key);
    }

    @Override
    public String toString() {
        return hm.toString();
    }

    public static void main(String[] var0) { 
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println("After putting key - value pairs : " + myHashMap);
        System.out.println("Value for the Key 1 : " + myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println("Value for the Key 3 : " + myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println("After updating key - value pairs : " + myHashMap);
        System.out.println("Updated Value for the Key 2 : " + myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println("After removing key - value pair : " + myHashMap);
        System.out.println("Value for the Key 2 : " + myHashMap.get(2));
    }
}

