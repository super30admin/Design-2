// Time Complexity : o(1) means constant time 
// Space Complexity : o(1) i was confused with with but I think its should be constant as well
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : few but I listened recorded videos


// Your code here along with comments explaining your approach
class MyHashSet {
  boolean[][] Storage;  // two dimentional array 
    int buckets; 
        int bucketItems;
    
    
    public MyHashSet() { // constructors 
   //and also intialize the values here 
         buckets = 1000; //intialize 1000 buckets 
         bucketItems = 1000; //her 1000
        Storage = new boolean[buckets][];  // give size of buckets to array as second array is still empty as its for future bucket items 
    
          }
    
    //two hashfunctions
    
    private int getBucket(int key){// it return the key(index) of primary array
        return key % buckets;  
      
    }
    //first hashing method 
    private int getBucketItem(int key){// it returns the key(index) of secondary arry 
        return key / bucketItems;
    }
  
  //second hashing method
    
    public void add(int key) {
        
        int bucket = getBucket(key);  //  call buccket method 
        int bucketItem = getBucketItem(key); // call bucketitem method 
        
        if(Storage[bucket]==null) // if  primary array is null //means we did not have secondry arry 
        {
          
            if(bucket==0){ //then check if bucket is zero  then do 
              
                Storage[bucket] = new boolean[bucketItems + 1]; // if bucket is zero initalize the bucketitems + 1  to primrary array 
            }
            else{
                Storage[bucket] = new boolean[bucketItems]; // esle do this 
            }
        }
        Storage[bucket][bucketItem] = true;  // with i have bhut the items of bucket and bucket items 
    }
    
    public void remove(int key) {
        int bucket = getBucket(key); // call bucket method 
        int bucketItem = getBucketItem(key); // call bucket method 
        if(Storage[bucket]==null){ //check if the bucket is null return 0
            return; 
        }
        Storage[bucket][bucketItem]=false; //set false to both arrays
    }
    
    public boolean contains(int key) {
         int bucket = getBucket(key); // call method bucket
        int bucketItem = getBucketItem(key);// call method bucketItems 
         if(Storage[bucket]==null){ //check if bucket id null return false 
            return false;
    
   }
             return Storage[bucket][bucketItem];
     }
}
