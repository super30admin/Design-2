/*
Author: Akhilesh Borgaonkar
Approach: I am using array to repeat the functionality of hashset. Whenever an element is added in set, I set the key-th index to 1 (viz. by default 0).
    Whenever an element is removed, I am setting the key-th index as 0 which means the element is no more contained in the set.
    Whenever user wants to check if an element is contained in the set, then I just check the value of key-th index if 1 then contains else missing.
Time Complexity: O(1) for all methods
Space Complexity: O(n)  where n is number of elements in array
LC verified
*/

class MyHashSet {

    int MAX = 100000;
    Integer[] myArray = new Integer[MAX];   //array for storing elements in set

    public MyHashSet() {
        Arrays.fill(myArray,0);     //set all indexes to 0      
    }
    
    public void add(int key) {
        myArray[key] = 1;           //setting key-th index as 1
    }
    
    public void remove(int key) {
        myArray[key]=0;             //setting key-th index as 0
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(myArray[key]==1)         //if the key-th index is 1 then return true else element is not in array
            return true;
        return false;
    }
}