// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No


//Approach - Use 2 dimensional array and double hashing technique, leaner chaining strategy to achieve O(1) for both time complexity,
// space complexity and minimize  the collusion.  Initialize the primary Array with size of
// 1000 elements and only create the secondary array as needed basis to optimize storage and handled the edge case of hashing key
// of 1000000 by creating 10001 elements space for 0th element
// Created a custom class Pair to keep key value pairs similar to Node

public class MyHashMap {

    private Pair[][]  storage;
    private int size;
    public MyHashMap1(){
        size = 10000;
        storage = new Pair[size][];
    }
    private int hash1(int key){
        return key % this.size;
    }
    private int hash2(int key){
        return key / this.size;
    }
    public int get(int key) {
        int h1 = hash1(key);
        if (storage[h1] == null) return -1;
        int h2 = hash2(key);
        if(storage[h1][h2] == null) return -1;
        return storage[h1][h2].value;
    }

    public void put(int key, int val) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(storage[h1] == null) {
            //handle edge case of storing key as 1000000
            // 1000000%10000 = 0
            // 1000000/1000 = 1000
            if(h1 == 0){
                storage[h1] = new Pair[1001];
            }else{
                storage[h1] = new Pair[1000];
            }
        }
        storage[h1][h2] = new Pair(key,val);

    }
    public void remove(int key){
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (storage[h1] == null ||
            storage[h1][h2] == null ) return;
        storage[h1][h2] = null;
    }
    class Pair{
        int key;
        int value;
        public Pair(int key, int val){
            this.key = key;
            this.value  =val;

        }
    }
}
