// Time Complexity : for add and remove O(N), for containts O(1)
// Space Complexity : O(1000001)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understood this problem well.

class MyHashSet {
  /** Initialize your data structure here. */
    public MyHashSet() {
        hashset = new boolean[1000001];
    }

    private boolean[] hashset = new boolean[1000001];

    public void add(int key) {
        hashset[key] = true;
    }

    public void remove(int key) {
        hashset[key] = false;
    }

  /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashset[key];
    }
  
}