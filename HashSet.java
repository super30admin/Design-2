class MyHashSet {

    int[] set;
     MyHashSet() {
        set = new int[1000001];
        Arrays.fill(set,-1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key] == -1? false: true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 