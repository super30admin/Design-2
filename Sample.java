// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;
    
    public MyHashSet() {
        this.bucket = 1000; 
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];       
    }

    private int hash1(int key){
        return key%bucket;
    }

    private int hash2(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int arr1Loc= hash1(key);
        int arr2Loc = hash2(key);
        if(storage[arr1Loc]==null){
            if(arr1Loc==0){
                storage[arr1Loc] = new boolean[bucketItems+1];
            } else 
            {storage[arr1Loc] = new boolean[bucketItems];
            }
        }          
        storage[arr1Loc][arr2Loc] = true;

    }
    
    public void remove(int key) {
         int arr1Loc= hash1(key);
         int arr2Loc = hash2(key); 
        if(storage[arr1Loc]==null){
            return;
        } 
            storage[arr1Loc][arr2Loc] = false;
        }
    
    
    public boolean contains(int key) {
        int arr1Loc= hash1(key);
        int arr2Loc = hash2(key); 
        if(storage[arr1Loc]==null){
            return false;
        } 
         return storage[arr1Loc][arr2Loc] ;
    }
}
