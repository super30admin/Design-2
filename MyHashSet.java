// Time Complexity :
//      add() - O(1)
//      remove() - O(1)
//      contains() - O(1)
//      getHash1() - O(1)
//		getHash2() - O(1)
//      
// Space Complexity :
//      overall - O(n)
//      add() - N/A
//      remove() - N/A
//      contains() - N/A
//      getHash1() - N/A
//		getHash2() - N/A
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
	static final int MAX = 1000;
	int[] array;
	
	public MyHashSet() {
		//initilaize the base array
		array = new int[MAX];
	}

	public void add(int value) {
		//get the double hash index
		array[getHash2(getHash1(value))] = value;
	}

	public boolean contains(int value) {
		//check if the location at the double hash index is empty
		if(array[getHash2(getHash1(value))] == 0)
			return false;
		else
			return true;
	}

	public void remove(int value) {
		//assign zero to the double hash index
		if(array[getHash2(getHash1(value))] == value)
			array[getHash2(getHash1(value))] = 0;
	}

	int getHash1(int value)
	{
		//return hash1 index
		return value % 100;
	}

	int getHash2(int value)
	{
		//return has2 index
		return value % 100;
	}

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		System.out.println("contains(1) -> " + hashSet.contains(1));  // returns true
		System.out.println("contains(3) -> " + hashSet.contains(3));  // returns false
		hashSet.add(2);
		System.out.println("contains(2) -> " + hashSet.contains(2));  // returns true
		System.out.println("remove(2)");
		hashSet.remove(2);
		System.out.println("contains(2) -> " + hashSet.contains(2));  // returns false

	}

	
}