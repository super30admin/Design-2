// Time Complexity : best case O(1) Worst case O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Implemented HashMap using Chaining - Array of List nodes with key, value pairs
// Approximated size of array, used a prime multiplier and modulo to the size of array to generate hash value for array index
class MyHashMap {

    static final int size = 10000;
    static final int hashMultiplier = 7;
    //Node containing data	
    EntryKV[] data;


    //The constructor initializes an array of list nodes
    public MyHashMap() {
        this.data = new EntryKV[size];

    }

    //Hashing function to generate index from key. Multiplied with a prime number and modulo with size of array 
    // for random distribution of keys  
    private int hash(int key) {
        return (int)((long) key*hashMultiplier % size);
    }

    //Used to add new value to the map
    //If the same key already exists, remove it
    //Generate hash value of key for array index, create a list node and add it to the top(head) of the linked list
    public void put(int key, int value) {
        //If the key already exists in the map, we need to replace it so just remove the node
        remove(key);
        int h = hash(key);
        //Adding the node on top of other nodes with same key (LIFO)
        EntryKV node = new EntryKV(key, value, data[h]);
        data[h] = node;
    }

    //Used to retrieve value of given key
    //Get the hash of key to generate index value for lookup
    //If the linkedlist has more than 1 node, traverse to fetch the key-value pair using for loop
    public int get(int key) {
        int h = hash(key);
        EntryKV node = data[h];
        for(; node != null; node = node.next)
            if(node.key == key) return node.val;
        return -1;
    }

    //Used to remove an entry from the map
    //Generate hash for lookup of the entry
    //traverse through the list and if any key's next is matching, move the next to next's next
    public void remove(int key) {
        int h = hash(key);
        EntryKV node = data[h];
        //If the key is not present in array
        if(node == null) return;
        //If key is found in first position, abandon first entry and point to second one(LIFO)
        if(node.key == key) data[h] = node.next;
            //If not first, check from second and when found jump next over the matched node
        else {
            for(; node == null; node = node.next)
                if(node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
        }

    }
}

//List nodes of key, value pairs
class EntryKV {
    int key, val;
    EntryKV next;
    public EntryKV(int key, int val, EntryKV next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */