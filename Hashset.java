//I tried to make arraylist of linkedlist and store value in those linked list but my code does not work. I am not sure what is the issue.
class MyHashSet {

    /** Initialize your data structure here. */
    
    ArrayList<LinkedList<Integer>> hashset;
    int hash;
    public MyHashSet() {
        hashset= new ArrayList<>();
        hash=2096;  
        for(int i=0;i<hash;i++)
            hashset.add(new LinkedList< >());
    }
    
    public void add(int key) {
        if(hashset.get(key%hashset.size())==null)
            hashset.get(key%hash).add(key);
    }
    
    public void remove(int key) {
         
                hashset.get(key%hash).remove(key);
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hashset.get(key%hash).contains(key))
            return true;
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