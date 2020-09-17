/*
   
Design Hash-set
*/

//Time comlpexity - O(1) 
//space complexity - O(n) 
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : I am confused about the space complexity

*/

// Your code here along with comments explaining your approach

class MyHashSet {

  int buckets;
  int bucketItems;
  boolean [][] storage;

  /** Initialize your data structure here. */
  public MyHashSet() {
    buckets = 1001;
    bucketItems = 1000;
    storage = new boolean[buckets][];  
      
  }

  private int bucket(int key)
  {
    return key%buckets;
  }

  private int bucketItem(int key)
  {
    return key/bucketItems;
  }
  
  public void add(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketItem(key);
    if(storage[bucket] == null)
    {
      storage[bucket] = new boolean[bucketItems];
    }
    storage[bucket][bucketItem] = true;      
  }
  
  public void remove(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketItem(key);
    if(storage[bucket] != null)
    {
      storage[bucket][bucketItem] = false;
    }      
  }
  
  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketItem(key);
    if(storage[bucket] == null)
    {
      return false;
    }
    else
    {
      return storage[bucket][bucketItem];
    }
      
  }
}
