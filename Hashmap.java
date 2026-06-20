// Time Complexity : O(1) for put, get and remove operations
// Space Complexity : O(n) where n is the number of unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * The row index will be calculated using the modulus operator and the column index will be calculated using the division operator. 
 * This way, we can store up to 1000000 unique keys in the hash map. 
 * To handle collisions, we will initialize the second dimension of the array with a size of 1001, so that we can store values for keys that have the same row index.
 * Since the value 0 is used to indicate that a key is not present in the hash map, we will store the value as value+1 to differentiate between a key that is not present and a key that has a value of 0.
 */
import java.util.*;
class MyHashMap {
     int array[][] = new int[1000][];

    public MyHashMap() {
       
        
    }
    public int row(int key){
        return key%1000;

    }

    public int column(int key){
        return key/1000;

    }
    
    public void put(int key, int value) {
         int row = row(key);
        int column = column(key);
        if(array[row]==null){
            array[row] = new int[1001];
        }
        array[row][column] = value+1;
        
        

        
    }
    
    public int get(int key) {
         int row = row(key);
        int column = column(key);
        int value = -1;
        if (array[row] !=null){
            return array[row][column]-1;
        }
        return -1; 
        
    }
    
    public void remove(int key) {
         int row = row(key);
        int column = column(key);
         if( array[row] !=null){
         array[row][column] =0;
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