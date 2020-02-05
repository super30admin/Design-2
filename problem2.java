/*
Time Complexity: Add & Contains O(1)
Remove O(N), where n is the no of the elements

Space Complexity: O(1)


*/

class MyHashSet {

    //using dynamic datastructure 
    ArrayList<Integer> set ; 
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new ArrayList<>() ; 
    }
    
    public void add(int key) {
        if (!contains(key))
            set.add(key) ; 
        return ; 
    }
    
    public void remove(int key) {
         if (contains(key))
             set.remove(new Integer(key)) ;
        return ; 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return  (set.contains(key)) ; 
    }
}
