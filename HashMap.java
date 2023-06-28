// Time Complexity : All user operations are O(1).
// Space Complexity : No extra space used for user operations O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Implemented the double hashing technique to acheive O(1) time complexity.

class MyHashMap {
    Item[][] map;
    int size = 1000;

    public MyHashMap() {
        map = new Item[1000][];
    }

    //Time complexity: O(1)
    //Space complexity: O(1)
    private int _hash(int key){
        return key % this.size;
    }

    //Time complexity: O(1)
    //Space complexity: O(1)
    private int _hash2(int key){
        return key / this.size;
    }
    
    //Time complexity: O(1)
    //Space complexity: O(1)
    public void put(int key, int value) {
        int hashKey = _hash(key);
        int secondHashKey = _hash2(key);

        if(map[hashKey] == null){
            if(hashKey == 0){
                map[hashKey] = new Item[this.size+1];
            }else{
                map[hashKey] = new Item[this.size];
            }
        }

        map[hashKey][secondHashKey] = new Item(key, value);
    }
    
    //Time complexity: O(1)
    //Space complexity: O(1)
    public int get(int key) {
        int hashKey = _hash(key);
        int secondHashKey = _hash2(key);

        if(map[hashKey] == null || map[hashKey][secondHashKey] == null){
            return -1;
        }

        return map[hashKey][secondHashKey].val == Integer.MIN_VALUE ? -1 : map[hashKey][secondHashKey].val;
    }
    
    //Time complexity: O(1)
    //Space complexity: O(1)
    public void remove(int key) {
        int hashKey = _hash(key);
        int secondHashKey = _hash2(key);

        if(map[hashKey] == null || map[hashKey][secondHashKey] == null){
            return;
        }

        map[hashKey][secondHashKey].val = Integer.MIN_VALUE;
    }
}

class Item{
    int key;
    int val;

    public Item(int key, int val){
        this.key = key;
        this.val =val;
    }
}
