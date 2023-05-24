// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Used a simple approach by using an array. The array's index value was used as the key and the value of the array as the value of the hashmap
class MyHashMap {
int[] map;
    public MyHashMap() {
        map = new int[1000000+1];
    }
    
    public void put(int key, int value) {
        map[key] = value+1;
    }
    
    public int get(int key) {
        return map[key]-1;
    }
    
    public void remove(int key) {
        map[key] = 0;
    }
}