// Time Complexity : O(1)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/*
hash and collision mechanism : double hash

hash1(key) = key % size1; this gives location in first array
hash2(key) = key / size2; this give location in second array

Base DS = Array[size2] in Array[size1]

*/
import java.util.*;

class MyHashMap { 
    
    private int size1 = 1000; // private makes abstraction
    private int size2 = 1000;
    
    int[][] arr;
    
    // hash functions are not accesible to user, hence private them to abstract
    private int hash1(int key) {
        return key%size1;
    }
    
    private int hash2(int key) {
        return key/size2;
    }

    public MyHashMap() {
        arr = new int[size1][];
    }
    
    public void put(int key, int value) {
        int hash1val = hash1(key);
        int hash2val = hash2(key);
        
        if (arr[hash1val] == null) {
            if (hash1val == 0) arr[hash1val] = new int[size2+1];
            else arr[hash1val] = new int[size2];
            
            Arrays.fill(arr[hash1val], -1);
        }
        
        arr[hash1val][hash2val] = value;
        
    }
    
    public int get(int key) {
        int hash1val = hash1(key);
        
        if (arr[hash1val] !=null) {
            int hash2val = hash2(key);
            return arr[hash1val][hash2val];
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int hash1val = hash1(key);
        
        if (arr[hash1val] !=null) {
            int hash2val = hash2(key);
            arr[hash1val][hash2val]=-1;
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