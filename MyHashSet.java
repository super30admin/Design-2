// Time Complexity : Insert-O(n), add-O(1),remove-O(n), contains-O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I was unable to do the hashing technique 
//(formula) and have reffered the leetcode solution, but later got the whole understanding about its implementation

class MyHashSet {

    private Bucket[] bucketArray;
    private int keyRange;
    public MyHashSet() {
        this.keyRange=769;
        this.bucketArray=new Bucket[this.keyRange];
        for(int i=0;i<this.keyRange;i++){
            this.bucketArray[i]=new Bucket();
        }
    }
    
    public int _hash(int key){
        return (key%this.keyRange);
    }
    public void add(int key) {
        int bucketIndex=this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }
    
    public void remove(int key) {
        int bucketIndex=this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }
    
    public boolean contains(int key) {
     int bucketIndex=this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
         
    }
}

class Bucket{
    private LinkedList<Integer> ll;
    Bucket(){
        ll=new LinkedList<Integer>();
    }
    
    public void insert(Integer key){
        int index=this.ll.indexOf(key);
        if(index==-1){
            this.ll.addFirst(key);
        }
    }
    
    public boolean exists(Integer key){
        int index=this.ll.indexOf(key);
        return (index!=-1);
    }
    
    public void delete(Integer key){
        this.ll.remove(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */