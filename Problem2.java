//Time Complexity : O(1) for put, get and remove
// Space Complexity : O(n) where n is the number of elements in the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We use an array of linked lists to handle collisions in the hash map.
// 2. Each linked list node contains a key-value pair, allowing us to store multiple pairs with the same hash index.
// 3. The put method adds or updates a key-value pair, get retrieves the value for a key, and remove deletes a key-value pair from the map.
class MyHashMap {
    // Node class to represent each key-value pair in the hash map
    class Node{
        int key; int val;
        // Pointer to the next node in the linked list
        // This allows us to handle collisions by chaining nodes with the same hash index
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    // Array to store the linked lists for each bucket in the hash map
    // The size of the array is determined by the number of buckets we want to use
    private Node[] storage;
    private int buckets;
    // Hash function to calculate the index for a given key
    // This function takes the key and returns the index in the storage array
    private int hash(int key){
        return key%buckets;
    }
    // Constructor to initialize the hash map with a default number of buckets
    public MyHashMap() {
        // Initialize the number of buckets to a default value
        this.buckets=1000;
        // Create the storage array with the specified number of buckets
        this.storage=new Node[buckets];
    }
    private Node helper(Node head,int key){
        // This method helps find the previous node in the linked list for a given key
        // It returns the node before the one with the specified key, or the last node if the key is not found
        Node prev=head;
        Node curr=head.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        // Calculate the index for the given key
        int idx=hash(key);
        // If the storage at the index is null, create a new node with a dummy value
        // This is done to avoid null checks later when we try to access the linked list at that index
        if(storage[idx]==null){
            storage[idx]=new Node(-1,-1);
        }
        // Use the helper method to find the previous node for the given key
        Node prev=helper(storage[idx],key);
        // If the previous node's next is null, it means the key does not exist in the map
        if(prev.next==null){
            // Create a new node with the key and value, and link it to the previous node
            // This effectively adds the new key-value pair to the linked list at that index
            prev.next=new Node(key,value);
        }else{
            // If the key already exists, update the value of the existing node
            // This allows us to modify the value associated with an existing key
            prev.next.val=value;
        }

    }
    
    public int get(int key) {
        // Calculate the index for the given key
        int idx=hash(key);
        // If the storage at the index is null, it means the key does not exist
        if(storage[idx]==null) return -1;
        // Use the helper method to find the previous node for the given key
        Node prev=helper(storage[idx],key);
        // If the previous node's next is null, it means the key does not exist in the map
        // We return -1 to indicate that the key is not found
        if(prev.next==null){
            return -1;
        }
        // If the key exists, return the value associated with that key
        return prev.next.val;
    }
    
    public void remove(int key) {
        // Calculate the index for the given key
        int idx=hash(key);
        // If the storage at the index is null, it means the key does not exist
        if(storage[idx]==null) return;
        // Use the helper method to find the previous node for the given key
        Node prev= helper(storage[idx],key);
        // If the previous node's next is null, it means the key does not exist in the map
        if(prev.next==null) return;
        // If the key exists, we remove the node by linking the previous node to the next node
        Node temp=prev.next;
        // This effectively removes the node with the specified key from the linked list
        prev.next=prev.next.next;
        temp.next=null;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */