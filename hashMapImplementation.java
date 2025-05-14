// Time Complexity : 
// put(), get(), remove() => O(1) average case, due to constant-time array access

// Space Complexity : 
// Worst case O(N), where N is the number of distinct keys up to 10^6
// (Each key maps to a 2D index; only allocated as needed)

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// Initially, it was difficult to handle the case where the value is 0,
// because Java initializes int arrays with 0 by default, so checking if a key exists
// required introducing a sentinel value (-1). This was resolved by initializing arrays with -1
// using Arrays.fill().

// Your code here along with comments explaining your approach
/* The method used in this problem is an extension of the Hashset problem.
 * This implementation uses a double hashing technique:
 * - hashKey1() maps the key to a primary index (outer array)
 * - hashKey2() maps the key to a secondary index (inner array)
 *
 * To avoid allocating full 10^6 space, we lazily allocate each secondary array only when needed.
 * Special case: when key is 10^6 (edge case), the second index will be 1000,
 * so we make sure that the 0th bucket has size 1001 instead of 1000.
 *
 * We use -1 as a sentinel value to indicate that a key has not been set.
 */

class MyHashMap {
    private int [][] storage;
    private int bucketSize;
    private int bucketItemsSize;

    private int hashKey1(int key){
        return key%1000;
    }
    private int hashKey2(int key){
        return key/1000;
    }

    public MyHashMap() {
        this.bucketSize = 1000;
        this.bucketItemsSize = 1000;
        this.storage = new int[bucketSize][];
    }
    
    public void put(int key, int value) {
        int first = hashKey1(key);
        if(storage[first] == null){
            if(first == 0)
                storage[first] = new int[bucketItemsSize+1];
            else
                storage[first] = new int[bucketItemsSize];
            Arrays.fill(storage[first],-1);
        }
        int second = hashKey2(key);
        storage[first][second] = value;
    }
    
    public int get(int key) {
        int first = hashKey1(key);
        int second = hashKey2(key);
        if(storage[first] == null || storage[first][second] == -1)
            return -1;
        return storage[first][second];
    }
    
    public void remove(int key) {
        int first = hashKey1(key);
        int second = hashKey2(key);
        if(storage[first] != null)
            storage[first][second] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
