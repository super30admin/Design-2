class MyHashSet {
    List <Integer>list; 
    boolean contained[];

    /** Initialize your data structure here. */
    public MyHashSet() {
         list =new ArrayList<Integer>();
         
         // Boolean array is used since list.remove() and list.contains() have time complxity of O(n)
         //Finding element by position instead of value saves cost and makes its O(1) instead of O(n)
        contained = new boolean[1000000];
    }
    
    public void add(int key) {
        if(!contained[key])
             list.add(key);
        contained[key] = true;
    }
    
    public void remove(int key) {
        if(contained[key])
        { 
            contained[key] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         if(contained[key])
        { 
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
 */Has
