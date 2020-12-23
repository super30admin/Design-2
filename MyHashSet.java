/**
Time Complexity : O(1)
Space Complexity : O(N*N)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : NO


Solution as discussed in class

Max input = 1000000

sqrt(1000000) = 1000

hash1 = input % 1000 

hash2 = input / 1000;

DataStructure:
    arrays of references to the arrays
    first arrays size = 1000, since hash1 will result to value between 0 to 999
    then at the location result of the firstr hash, the second hash will give the vale
    of the exact location in that given bucket.
    
    key = 2 at bucket[hash1][hash2] = bucket[2][0]
    key = 3 at bucket[3][0]
    
    key = 2002 at bucket[2][2]

Collabedit: http://collabedit.com/u46ys
**/



class MyHashSet {

    int bucketCount = 1000;
    int bucketArraySize = 1000;
    
    boolean bucketArray[][];


    /** Initialize your data structure here. */
    public MyHashSet() {
        this.bucketCount = 1000;
        this.bucketArraySize = 1000;
        
        // we will be dynamically allocating the space to each array
        this.bucketArray = new boolean[bucketCount][];
    }
    
    public void add(int key) {
    
        int hash1 = this.firstHash(key);
        
        // this mean previously no key resulted in the hash value equal to hash1
        if(this.bucketArray[hash1] == null) {
        
            this.bucketArray[hash1] = new boolean[bucketArraySize];
        }
        
        int hash2 = this.secondHash(key);
        
        this.bucketArray[hash1][hash2] = Boolean.TRUE;
   
    }
    
    public void remove(int key) {
        
        boolean contains = this.contains(key);
        
        if(contains)
            this.bucketArray[this.firstHash(key)][this.secondHash(key)] = Boolean.FALSE;
        else
            return;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int hash1 = this.firstHash(key);
        
        if(this.bucketArray[hash1] == null)
               return false;
               
        int hash2 = this.secondHash(key);
        
        return this.bucketArray[hash1][hash2];
    }
    
    public int firstHash(int key) {
    
        return key % bucketCount;
    }
    
    public int secondHash(int key) {
        
        return key / bucketCount;
    
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */