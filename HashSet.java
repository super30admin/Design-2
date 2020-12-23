// Time Complexity :O(log(m*n))
// Space Complexity :all the operation will take O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :mapping the the midpoint element to matrix.


// Your code here along with comments explaining your approach

//one way is the brute force approach which will take O(n^2)
class MyHashSet {

   int firstBucket;
	int secondBucket;
	boolean[][] arr;

	public int getFirstBucket(int value) {
		return (value % firstBucket);
	}

	public int getSecondBucket(int value) {
		return (value / secondBucket);
	}

	public MyHashSet() {
		firstBucket = 1000;
		secondBucket = 1000;
		arr = new boolean[firstBucket][];
	}

	public void add(int key) {
		if (arr[getFirstBucket(key)] == null) {
			arr[getFirstBucket(key)] = new boolean[secondBucket];
			
		} 
			arr[getFirstBucket(key)][getSecondBucket(key)] = true;
		
	}

	public void remove(int key) {
		if (arr[getFirstBucket(key)] != null) {
			arr[getFirstBucket(key)][getSecondBucket(key)] = false;
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		if (arr[getFirstBucket(key)] != null) {
			return (arr[getFirstBucket(key)][getSecondBucket(key)]);
		}
		return false;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */