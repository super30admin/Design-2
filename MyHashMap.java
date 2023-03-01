// Simple implementation using an array of size corresponding to input and using the input key as index of the array.
// At each index, simply insert the value provided.
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class MyHashMap {
		int [] arr;

	    public MyHashMap() {
	    	arr = new int [1000001];
	    	for (int i = 0; i < arr.length; i++) {
	    	    arr[i] = -1;
	    	}
	    }
	    
	    public void put(int key, int value) {
	        arr[key] = value;
	    }
	    
	    public int get(int key) {
	        return arr[key];
	    }
	    
	    public void remove(int key) {
	        arr[key] = -1;
	    }
	}


