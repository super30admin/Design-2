// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : yes I did face some errors like printing null

// This implementation of a HashMap is based on using two ArrayLists to store keys and values, respectively.

import java.util.ArrayList;


// declaring two instance variables
class MyHashMap {
    ArrayList<Integer> keyList;
    ArrayList<Integer> valList;
    // defining constructor 

    public MyHashMap() {
        keyList = new ArrayList<>();
        valList = new ArrayList<>();
    }
    //The put method is used to insert a key-value pair into the HashMap. 
    //If the key already exists in the keyList, it means the value for that key needs to be updated. 
    //So, it checks if the keyList contains key. If the key is found, it retrieves its index and then updates the corresponding value in the valList 
    // if key is not found it means its a new key and needs to be added to list along with key and value
    public void put(int key, int value) {
        if (keyList.contains(key)) {
            int i = keyList.indexOf(key);
            valList.set(i, value);
        } else {
            keyList.add(key);
            valList.add(value);
        }
    }
    //The get method is used to retrieve the value associated with a given key from the HashMap.
    // It first checks if the keyList contains the key.
    // If the key is not found, it means there is no mapping for the key in the HashMap, so it returns -1.
    //If key is found it retrives the index and  returns corresponding value

    public int get(int key) {
        if (!keyList.contains(key)) {
            return -1;
        } else {
            int i = keyList.indexOf(key);
            return valList.get(i);
        }
    }

    //The remove method is used to delete a key-value pair from the HashMap.
    // It first checks if the keyList contains the key .
    //If the key is found, it retrieves its index  and then removes the key-value pair from both keyList and valList at that index
    public void remove(int key) {
        if (keyList.contains(key)) {
            int i = keyList.indexOf(key);
            keyList.remove(i);
            valList.remove(i);
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyHashMap
        MyHashMap hashMap = new MyHashMap();

        // Test case
        ArrayList<Integer> output = new ArrayList<>();

        // Method calls
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        output.add(hashMap.get(1));    // Output: 1
        output.add(hashMap.get(3));    // Output: -1
        hashMap.put(2, 1);
        output.add(hashMap.get(2));    // Output: 1
        hashMap.remove(2);
        output.add(hashMap.get(2));    // Output: -1

  
    }
}









// Your code here along with comments explaining your approach
