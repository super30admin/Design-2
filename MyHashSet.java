package s30Coding;

//Time Complexity
//	add :- O(1)
// remove :- O(1)
//contains : O(1)


// Space complexity :- O(1)

//Code runs successfully on LeetCode

//No difficulties

public class MyHashSet {
	/** Initialize your data structure here. */
	private int[] arr;
    public MyHashSet() {
        arr = new int[100000];
    }
    
    public void add(int key) {
        arr[key] = 1; 
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arr[key] == 1) {
        	return true;
        }
        return false;
    }
}
