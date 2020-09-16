// Time Complexity : Worst Case: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class MyHashSet {

    int hashSet[];

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.hashSet = new int[1000001];
        Arrays.fill(hashSet,-1);
    }
//Considering Array Index as key
    public void add(int key) {
        hashSet[key] = key;
    }

//When removed, initialize that key with -1
    public void remove(int key) {
        hashSet[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        boolean isExist = hashSet[key] == -1 ? false : true;
        return isExist;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
