import java.util.*;

class MyHashSet {

    private HashMap<Integer, Integer> map = new HashMap<>();
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        map.put(key, null);
    }
    
    public void remove(int key) {
        map.remove(key);   
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */