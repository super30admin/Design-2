// Time Complexity : O(1) for add, remove and contains
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MyHashSet {
    
    private boolean [][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

//calculates primary storage array hashing function    
    private int bucketHashing(int key){
        return key % buckets;
    }

//calculates nested array hashing function    
    private int bucketItemsHashing(int key){
        return key / bucketItems;
    }

//adds key to the HashSet in constant time    
    public void add(int key) {
        int bucket = bucketHashing(key);
        int bucketItem = bucketItemsHashing(key);

//checks edge case in 0th primary location - if yes adds one extra space to handle edge case        
        if(storage[bucket] == null){
            if(bucket == 0)
            {
                storage[bucket] = new boolean[bucketItems + 1];
            }            
        else{
            storage[bucket] = new boolean[bucketItems];
        }
    }
        storage[bucket][bucketItem] = true;                 //simply marks location true to signify element addition
    }
 
//removes element    
    public void remove(int key) {
        int bucket = bucketHashing(key);
        int bucketItem = bucketItemsHashing(key);
        
        if(storage[bucket] == null)
        {
            return;                                 //if no nested array is created, simply return
        }
        else{
            storage[bucket][bucketItem] = false;    //simply mark location false to signify removal of element
        }        
    }
    
//checks if the key is present; if yes returns true    
    public boolean contains(int key) {
        int bucket = bucketHashing(key);
        int bucketItem = bucketItemsHashing(key);
        if(storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];
    }
}


//Driver Code
class Main{
    public static void main(String[] args){
        MyHashSet hash = new MyHashSet();
        hash.add(10);
        System.out.println("10 present: " + hash.contains(10));
        hash.add(20);
        System.out.println("20 present: " + hash.contains(10));
        hash.add(30);
        System.out.println("30 present: " + hash.contains(10));
        hash.add(40);
        System.out.println("40 present: " + hash.contains(10));

        hash.remove(10);
        System.out.println("10 present: " + hash.contains(10));
        hash.remove(30);
        System.out.println("30 present: " + hash.contains(10));
    }
}
