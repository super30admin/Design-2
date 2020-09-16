// Time Complexity : O(N/k) - N is the number of possible values and k is number of predefined buckets
// Space Complexity : O(k + m)- k is number of buckets and m is number of unique values in the set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;
  
    /** Initialize your data structure here. */
    public MyHashSet() {
      this.keyRange = 769;
      this.bucketArray = new Bucket[this.keyRange];
      for (int i = 0; i < this.keyRange; ++i)
        this.bucketArray[i] = new Bucket();
    }
  
    protected int _hash(int key) {
      return (key % this.keyRange);
    }
  
    public void add(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].insert(key);
    }
  
    public void remove(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].delete(key);
    }
  
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
      int bucketIndex = this._hash(key);
      return this.bucketArray[bucketIndex].exists(key);
    }
  }
  //Here we used a class bucket wich contains a linkedlist
  //We considered each bucket to be a linked list
  
  class Bucket {
    private LinkedList<Integer> container;
  
    public Bucket() {
      container = new LinkedList<Integer>();
    }
  
    public void insert(Integer key) {
      int index = this.container.indexOf(key);
      if (index == -1) {
        this.container.addFirst(key);
      }
    }
  
    public void delete(Integer key) {
      this.container.remove(key);
    }
  
    public boolean exists(Integer key) {
      int index = this.container.indexOf(key);
      return (index != -1);
    }
  }
  
  /**
   * Your MyHashSet object will be instantiated and called as such:
   * MyHashSet obj = new MyHashSet();
   * obj.add(key);
   * obj.remove(key);
   * boolean param_3 = obj.contains(key);
   */

// Your code here along with comments explaining your approach
