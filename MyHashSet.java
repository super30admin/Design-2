// Time Complexity :  add()-O(1), contains()-O(1), remove()-O(1)
// Space Complexity : O(n) where n is the 10^6 here or maximum number of input possible
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashSet {
    // a 2-D array reprsenting our set
    boolean[][] set;
    //number of bucket
    int bucket;
    //number of items within bucket
    int bucketItem;

    // Initializing member variables
    public MyHashSet() {
        //initializing number of buckets
        this.bucket = 1000;
        //initilizing our set
        this.set = new boolean[this.bucket][];
    }
    // first hash function to fetch bucket number
    public int hash1(int key){
        return key%1000;
    }
    //second hash function to find item location inside bucket
    public int hash2(int key){
        return key/1000;
    }

    // puts a key/value in set
    public void add(int key) {
        //fetching bucket index from the key
        int bucket = this.hash1(key);
        //checking if the bucket doesn't exists
        if(this.set[bucket]==null){
            //create a bucket
            this.bucketItem = 1001;
            this.set[bucket] = new boolean[this.bucketItem];
        }
        //get item index within bucket
        int bucketItem = this.hash2(key);
        //mark item as available
        this.set[bucket][bucketItem] = true;
    }
    //remove a key/value from Set
    public void remove(int key) {
        //fetching bucket index
        int bucket = this.hash1(key);
        //checking if the bucket doesn't exists
        if(this.set[bucket]==null){
            return;
        }
        //get key index within bucket
        int bucketItem = this.hash2(key);
        //mark current location as empty
        this.set[bucket][bucketItem] = false;
    }

    // checks if an item exists in our set
    public boolean contains(int key) {
        //fetching bucket index
        int bucket = this.hash1(key);
        //checking if the bucket doesn't exists
        if(this.set[bucket]==null){
            return false;
        }
        //get key index within bucket
        int bucketItem = this.hash2(key);
        //return value at the index
        return this.set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */