// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Implemented HashMap using double hashing technique
class MyHashMap {
    private class Node{
        int key;
        int value;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    public Node[][] storage;
    public int buckets;
    public int bucketsize;
    public int hash1(int x){
        return x%buckets;}
    public int hash2(int x){
        return x/bucketsize;}
    public MyHashMap() {
        this.storage = new Node[1000][];
        this.buckets=1000;
        this.bucketsize=1000;
    }
    
    public void put(int key, int value) {
        int pidx = hash1(key);
        int sidx = hash2(key);
        if(storage[pidx] == null){
            if(pidx == 0)
                storage[pidx] = new Node[bucketsize+1];
            else
                storage[pidx] = new Node[bucketsize];

        }
        storage[pidx][sidx] = new Node(key,value);
    }
    
    public int get(int key) {
        int pidx = hash1(key);
        int sidx = hash2(key);
        if(storage[pidx]==null || storage[pidx][sidx]==null)
            return -1;
        return storage[pidx][sidx].value;
        
    }
    
    public void remove(int key) {
        int pidx = hash1(key);
        int sidx = hash2(key);
        if(storage[pidx]==null)
            return;
        storage[pidx][sidx]=null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */