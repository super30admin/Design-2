// Time Complexity :1
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I was getting index out of bound exception and null pointer exception also
//this is new commeng-------------------

// Your code here along with comments explaining your approach
//
class MyHashSet {

    //initialising an integer variable buckets to 1000
    //initialising an integer variable bucketItems to 1000
    int buckets=1000;
    int bucketItems=1000;
    //making a two dimensional array if buckets and bucketItems 
    boolean[][] storage=new boolean[buckets][];
     //method to return the value of bucket
    private int bucket(int value)
    {//return position of the value in main array
        return value%buckets;
    }
    //method to return the value of bucketItem
     private int bucketItem(int value)
    {   //return position of the value in nested array
        return value/buckets;
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int value) 
    {   //get the positions of the value element
        int bucket=bucket(value);
        int bucketItem=bucketItem(value);
        //if yhe main list is null, make a new element in the array
        if(storage[bucket]==null)
        {storage[bucket]=new boolean[bucketItems];
        }
        //give the value in nested array as true
         storage[bucket][bucketItem]=true;   
    }
    
    public void remove(int value) 
    {   //get the positions of the value element
        int bucket=bucket(value);
        int bucketItem=bucketItem(value);   
        //if the position is not empty
         if(storage[bucket]!=null)
        //give the complete position(nested array) as false 
        {storage[bucket][bucketItem]=false;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int value) 
    {   //get the positions of the value element
        int bucket=bucket(value);
        int bucketItem=bucketItem(value);   
        //if the position is not empty return true either false
        return storage[bucket]!=null && storage[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */