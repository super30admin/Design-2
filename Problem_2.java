/*
   
Design Hash-set
*/

//Time comlpexity - O(log n/k) 
//space complexity - O(k+m) 
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/

// Your code here along with comments explaining your approach

class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;
  
    /** Initialization here. */
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
  
    //return true if value is present
    public boolean contains(int key) {
      int bucketIndex = this._hash(key);
      return this.bucketArray[bucketIndex].exists(key);
    }
  }
  
  
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
  