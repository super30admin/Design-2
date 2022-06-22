// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// Array with index as key and value in it as value
class MyHashMap {

    int arr[];
    public MyHashMap() {
        arr = new int[1000001];
    }
    
    public void put(int key, int value) {
        arr[key] = value+1;
    }
    
    public int get(int key) {
        return arr[key] -1;
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
}
