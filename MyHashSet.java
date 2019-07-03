class MyHashSet {
    List <Integer>list; 
    boolean contained[];

    /** Initialize your data structure here. */
    public MyHashSet() {
         //list =new ArrayList<Integer>();
        contained = new boolean[1000000];
    }
    
    public void add(int key) {
        if(!contained[key])
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
 */
