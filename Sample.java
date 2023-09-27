// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : this solution won't give you the Exact functionality of the HashMap and This implementation doesn't handle collisions.
If two different keys hash to the same index in the map array, one will overwrite the other.*/


// Your code here along with comments explaining your approach

class MyHashMap {
    int [] map;   // declares a variable map that can hold an array of integers
    
    public MyHashMap() {
        map = new int [1000001]; // created an array with the length of the 1000001 
    }
    
    public void put(int key, int value) {
        map[key] = value+1;     // here By adding 1 to the value before storing it, we ensure that explicitly set values are greater than 0, while uninitialized entries remain 0.
    }
    
    public int get(int key) {
      return map[key]-1;    // The reason for subtracting 1 from the value is related to how the put method was implemented in this HashMap 
    }
    
    public void remove(int key) {
       map[key] = 0;    // After accessing the value from the map array using map[key], I set it to 0.
    }
}
