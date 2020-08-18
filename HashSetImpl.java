// Time Complexity : O(1)
// Space Complexity : O(1)  as the size of arr is constant (correct me if i am wrong)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : couldnt come up with optimal solution, Looking forward to class for better approach.

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] arr;
    public MyHashSet() {
        arr=new boolean[10000001];                          //initialized arr ds with the upper limit of the range
       
        
    }
    
    public void add(int key) {
        arr[key]=true;                                     //making the value at the index(key) as true(index equal to key)
        
    }
    
    public void remove(int key) {
        arr[key]=false;                                  //making the value at index(key) as false to remove the ele  
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];                                 //just return the value at the index(key) true-contains, false-doesnt
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */