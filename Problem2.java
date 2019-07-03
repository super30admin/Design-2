class MyHashSet {
    boolean[] hashArr;
    public MyHashSet() {
        hashArr = new boolean[1000];
    }
    
    public void add(int key) {
        if(key>=hashArr.length)
            extend(key);
        hashArr[key]=true;
    }
    
    public void remove(int key) {
        if(key>=hashArr.length)
            extend(key);
        hashArr[key]=false;
    }
    
    public boolean contains(int key) {
        if(key>=hashArr.length)
            return false;
        return hashArr[key]==true;
    }
    
    public void extend(int key){
        hashArr= Arrays.copyOf(hashArr, key+1);  
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */