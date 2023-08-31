class MyHashMap {

//Node class which helps in creating a node.
    private class Node
    {
        int key,value; // key, value stores the key value and its corresponsing value
        Node next; // tp store address of next node

// Constructor to initialize the Node class
        public Node(int key, int value)
        {
            this.key=key;
            this.value=value;
            this.next = null;
        }
    }


    Node[] storage; // Array to store addresses of the corresponding linked list.
    int buckets; // the size of the storage array

// Constructor for MyHashMap class
    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];
    }

// Method to get hash value for specific key
// Time complexity: O(1)
    private int getBucket(int key)
    {
     return Integer.hashCode(key)%this.buckets;
     //or return key% this.buckets;
    }

// Method to find the the node address for specific key provided
// The method returns prev as if return prev it would help us in remove method as well, so to make the code resusuable we are return prev instead of curr
// Time Complexity: O(n) where n is number of elements in the Linked List.
    private Node find(int key, Node dummy) //returns the prev node address
    {
        Node prev = dummy;
        Node curr = prev.next;

        while(curr!=null && curr.key!=key)
        {
            prev = curr;
            curr =curr.next;
        }
        return prev;
    }

    // This method allows us either to insert value for given key or replace the value for correponding key if its already exists.
    //Time Complexity: O(n) where n is number of elements in the Linked List for its specific bucket
    //The Time compxity for all other operations is O(1), only the find method has O(n)
    public void put(int key, int value) { 
        int bucket = getBucket(key); // Hashing(to get deterministic key value)
        if (storage[bucket] == null) // checking if the primary array/ bucket has a secondary linked list associated with it for following key.
        { 
          storage[bucket] =  new Node(-1,-1);// storing dummy node in the address of storage[bucket] that is primary array
        }
        
        // If the associated primary array/bucket does have a Linked List associated with it, so calling find method to check if the key already exists in the respective Linked List.
         Node prev = find(key, storage[bucket]);
         if (prev.next==null)
         {
             // if key does not exist, then create a new node with respective key and value and insert it to the end of the Linked List.
             prev.next = new Node(key,value);
         }
         else {
             // if key exists, then replace the corresponsing value with given value..
         prev.next.value = value; 
         } 
    }
    
    // This method helps in retrieving corresponding value for gievn key.
     //Time Complexity: O(n) where n is number of elements in the Linked List for its specific bucket
    //The Time compxity for all other operations is O(1), only the find method has O(n)
    public int get(int key) {
        int bucket = getBucket(key);// Hashing(to get deterministic key value)
        if (storage[bucket] == null) // checking if the primary array/ bucket has a secondary linked list associated with it for following key.
        {
            // If there is no Linked List associated with the bucket return -1.
            return -1;
        }
        // traverse the linked list untill you find this key.
        Node prev = find(key, storage[bucket]);
        if (prev.next==null)
        {
            // If the does not exist return -1.
            return -1;
        }
          // If key exists then return the value.
            return prev.next.value;
    }
    
    //This method helps in removing the specific key if it exists.
    //Time Complexity: O(n) where n is number of elements in the Linked List for its specific bucket
    //The Time compxity for all other operations is O(1), only the find method has O(n)
    public void remove(int key) {
        int bucket = getBucket(key);// Hashing(to get deterministic key value)
        if (storage[bucket] == null) // checking if the primary array/ bucket has a secondary linked list associated with it for following key.
        {
            // If the bucket does not have Linked List associated with it then nothing to be removed.
            return;
        }     
        //if the given key exists then replace the prev node's address with address stored in the given keys's next.  
          Node prev = find(key, storage[bucket]);
          if (prev.next!=null)
          {
              prev.next = prev.next.next;
          }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
