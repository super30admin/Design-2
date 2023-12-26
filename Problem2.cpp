// Time Complexity :O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

//Follwed the approach discussed in class.

class MyHashMap {
public:
    int mp[1000001]; // Use an array to represent a HashMap with fixed size.

    MyHashMap() {
        for (int i = 0; i < 1000001; ++i) {
            mp[i] = -1; // Initialize the array with -1, indicating empty slots in the HashMap.
        }
    }

    void put(int key, int value) {
        mp[key] = value; // Set the value at the key index to store the key-value pair in the HashMap.
    }

    int get(int key) {
        return mp[key]; // Retrieve the value at the key index from the HashMap.
    }

    void remove(int key) {
        mp[key] = -1; // Set the value at the key index to -1 to remove the key-value pair from the HashMap.
    }
};
