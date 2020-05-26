// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class MyHashSet {

    /** Initialize your data structure here. */
    int[] arrHash;
    public MyHashSet() {
        arrHash = new int[100000];
    }
    
    public void add(int key) {
        arrHash[key]=1;
    }
    
    public void remove(int key) {
        arrHash[key]=0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arrHash[key] == 1) {
        	return true;
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