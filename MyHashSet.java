import java.util.HashMap;
import java.util.Map;

class MyHashSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> hashMap;
    public MyHashSet() {
        
        hashMap = new HashMap();
    }
    
    public void add(int key) {
        hashMap.put(key, 1);
    }
    
    public void remove(int key) {
        hashMap.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashMap.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */