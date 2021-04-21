class MyHashSet {
    private boolean[][] storage;
    private int baseArray;
    private int nestedArray;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        // arr=new boolean[10000001];
        baseArray=1000;
        nestedArray=1000;
        storage=new boolean[baseArray][];
    }
    private int basehashCode(int key){
     return key%1000;   
    }
    private int nestedhashCode(int key){
        return key/1000;
    }
    public void add(int key) {
        // arr[key]=true;
        
        int indexinBaseArray=basehashCode(key);
        int indexinNestedArray=nestedhashCode(key);
        
        if(storage[indexinBaseArray]==null){
            if(indexinBaseArray==0){
                storage[indexinBaseArray]=new boolean[nestedArray+1];
            }else{
                storage[indexinBaseArray]=new boolean[nestedArray];
            }
            storage[indexinBaseArray][indexinNestedArray]=true;
        }else{
            storage[indexinBaseArray][indexinNestedArray]=true;
        }
        
    }
    
    public void remove(int key) {
        int indexinBaseArray=basehashCode(key);
        int indexinNestedArray=nestedhashCode(key);
        if(storage[indexinBaseArray]==null){
            return;
        }else{
            storage[indexinBaseArray][indexinNestedArray]=false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // if(arr[key])
        //     return true;
        // else
        //     return false;
        
        int indexinBaseArray=basehashCode(key);
        int indexinNestedArray=nestedhashCode(key);
        if(storage[indexinBaseArray]==null){
            return false;
        }else{
            return storage[indexinBaseArray][indexinNestedArray];
        }
    }
}
​
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
