// Time Complexity : O(1)
// Space Complexity : O(1) -- not sure about this
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Had to brainstorm with regards to Integer v/s int as the nested int array has default value
as 0 which gives issue as value for a key can also be 0 hence we cannot determine whether a key is empty or has 0 as its value. To solve
this we may assign default value of all the nested arrays as -1 but that needs to use for loop which disturbs the Time complexity. Hence 
instead used Integer array as it has default null value -- also here while comparing to null we can directly do '== null' and does not 
need any .equals() thing atleast while null comparison.  */

/* Approach followed -- 
Used a hash set of 1000 x 1000 as input is 10^6. Took squareRoot(10^6) x squareRoot(10^6) = 1000 x 1000 
Then used double hashing technique to avoid collision -- with outer array having hash function = n%rowLength and nested hash 
function as n/colLength
Stored the value at the inner hashed key location.
e.g. i/p = 1101 -- 1101%1000 = 1
                   1101/1000 - 101 -- Hence go to 1st index of primary array then go to 101th index of
                   secondary/nested array at this location and store the value for key=1101 here.
Also as 0 and 10^6 is inclusive as input the edge case for including 1001 elements instead of 1000 at index 0 of primary array is also
considered.
 */


// Your code here along with comments explaining your approach

class MyHashMap {

    private Integer[][] keys;
    private int row = 1000;
    private int col = 1000;
    private int key1;
    private int key2;

    private int hash1(int key){
        return key%row;
    }

    private int hash2(int key){
        return key/col;
    }

    public MyHashMap() {
        keys = new Integer[1000][];
    }
    
    public void put(int key, int value) {
        key1 = hash1(key);
        key2 = hash2(key);
        if(keys[key1]==null){
            if(key1==0){
                keys[key1] = new Integer[col+1];
                    
            } else{
                keys[key1] = new Integer[col];

                  
            }
        }
        keys[key1][key2] = value;
    }
    
    public int get(int key) {
        key1 = hash1(key);
        key2 = hash2(key);
        if(keys[key1]==null) return -1;
        if(keys[key1][key2]==null) return -1;
        return keys[key1][key2];
    }
    
    public void remove(int key) {
        key1 = hash1(key);
        key2 = hash2(key);
        if(keys[key1]!=null && keys[key1][key2]!=null){
            keys[key1][key2] = null;
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