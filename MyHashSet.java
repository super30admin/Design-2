// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : How do I determine Space Complexity for this or in general? I don't know if my answer for it is correct.
class MyHashSet {
    ArrayList<Integer> array;
    /** Initialize your data structure here. */
    public MyHashSet() {
       array = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        array.add(key);
    }
    
    public void remove(int key) {
        
        for(int i =0;i<array.size();i++)
        {
            if(array.get(i)==key)
            {
                array.remove(i);
                i--;
            }
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return array.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */