// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;
    int bucketItemsSize = 1000;
    public MyHashSet() {
        int bucketSize = 1000;
        storage = new boolean[bucketSize][];
        
    }
    public int getHash1(int val){
        return val%bucketItemsSize;
    }
    public int getHash2(int val){
        return val/bucketItemsSize;
    }
    public void add(int key) {
        int val1 = getHash1(key);
        if(storage[val1]==null){
            if(val1==0){
                storage[val1] = new boolean[bucketItemsSize+1];
            }
            else{
            storage[val1] = new boolean[bucketItemsSize];}
        }
        int val2 = getHash2(key);
        storage[val1][val2] = true;
    }
    
    public void remove(int key) {
        int val1 = getHash1(key);
        if(storage[val1]!=null){
            int val2 = getHash2(key);
            storage[val1][val2] = false;
        }

    }
    
    public boolean contains(int key) {

        int val1 = getHash1(key);
        if(storage[val1]!=null){
            int val2 = getHash2(key);
            return storage[val1][val2];
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