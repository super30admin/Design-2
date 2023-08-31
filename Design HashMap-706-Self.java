import java.util.ArrayList;

// The logic I have used is after getting specific hash code, the primary array will store address of Array List.
// The even elements of Array List will be key and corresponding odd value, that is the next value will be the value for that corresponding key.
class MyHashMap {
    int buckets; // size of the primary array
    ArrayList[] storage; // Primary array which would store the address of Array Lists
    
    // Constructor for class MyHashMap
    public MyHashMap() {

     this.buckets = 1000;
     this.storage = new ArrayList[buckets]; 
    }

   // Method to find if the key exists in the respective Array List which is passed in the method as input
   // Time complexity: O(n)
    public int find(int key, ArrayList<Integer> arr)
    { 
       for(int i=0;i<arr.size()-1;i=i+2)
       { 
          if (arr.get(i) == key)
          {
              return i;
          }
       }
       return -1;
    }

   // Method to get determinstic value for the given key
    // Time complexity: O(1)
    public int getHash(int key)
    {
        return Integer.hashCode(key)%this.buckets;
    }

    // Method to add a key and its corresponding value to the Array List for specific key. 
    // Time Complexity: O(n) as Find method has O(n) time complexity rest are O(1) operations
    public void put(int key, int value) {
       int buckets = getHash(key);   // Hashing(to get deterministic key value)
       if(storage[buckets]==null) // check if the address of Array List is there or not in the primary array for particular key 
       {
         storage[buckets] = new ArrayList<Integer>(); 
         storage[buckets].add(key); // Add key
         storage[buckets].add(value); // Add value
       }
     else
       {
           int i = find(key,storage[buckets]); // to check if the key exists, then at what index // return -1 if the key does not exist
           if(i == -1) // if key does not exist then add these key and its corresponding value to the same Array List
           { 
           storage[buckets].add(key); 
           storage[buckets].add(value);
           }
           else {
             storage[buckets].set(i+1,value); // if the key exists, then replace old value with new value
           }
       }
    }
    
    // Method to get value for given key
    // Time Complexity: O(n) as Find method has O(n) time complexity rest are O(1) operations
    public int get(int key) {

        int buckets = getHash(key);  // Hashing(to get deterministic key value)
        if(storage[buckets]==null)  // check if the address of Array List is there or not in the primary array for particular key 
        {
            return -1; // key does not exist
        }

        int i = find(key,storage[buckets]);

        if(i==-1)
        {
            return -1; // key does not exist
        }

        int a = (int)storage[buckets].get(i+1); // return value
        return a;
    }
    
    // Removing specific key and value
    // Time Complexity: O(n) as Find method has O(n) time complexity rest are O(1) operations
    public void remove(int key) {
        int buckets = getHash(key);   // Hashing(to get deterministic key value)
        if(storage[buckets]==null) // check if the address of Array List is there or not in the primary array for particular key 
        {
            return; // As the Array List does not exist nothing to remove
        }  
        int i = find(key,storage[buckets]); // check if the given key exists in array list
        if(i==-1) // if key does not exist then do nothing
        {
            return;
        }
        storage[buckets].remove(i); // else remove
        storage[buckets].remove(i);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
