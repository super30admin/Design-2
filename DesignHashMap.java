// Time Complexity :
//   - put(): O(1) average case, O(n) worst case. This is because in the worst case, all elements might hash to the same index, resulting in a linear search within the linked list.
//   - get(): O(1) average case, O(n) worst case. Similar to put(), in the worst case, all elements might hash to the same index, resulting in a linear search within the linked list.
//   - remove(): O(1) average case, O(n) worst case. Similar to put() and get(), in the worst case, all elements might hash to the same index, resulting in a linear search within the linked list.
// Space Complexity : O(n) where n is the number of key-value pairs inserted into the HashMap. This is because the storage array of size 10000 is used, and each element of this array may potentially have a linked list of nodes.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    class Node
    {
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage; // Array to hold linked lists
    public MyHashMap() {
        this.storage = new Node[10000]; // Initialize storage array
    }
    
    private int hash(int key)
    {
        return key % 10000; // Hash function to map keys to indices
    }
    
    // Function to search for a node with a given key in a linked list
    private Node search(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    // Function to insert a key-value pair into the HashMap
    public void put(int key, int value)
    {
        int idx = hash(key); // Calculate index for the key
        if(storage[idx] == null)
        {
            storage[idx] = new Node(-1, -1); // Create a dummy node if the index is empty
        }
        Node prev = search(storage[idx], key);
        if(prev.next == null)
            prev.next = new Node(key, value); // Add a new node if the key doesn't exist in the list
        else
        {
            // Update the value if the key already exists
            prev.next.val = value;
        }
    }
    
    // Function to get the value associated with a given key
    public int get(int key) {
        int idx = hash(key); // Calculate index for the key
        if(storage[idx] == null)
        {
            return -1; // Return -1 if the index is empty
        }
        Node prev = search(storage[idx], key);
        if(prev.next == null) return -1; // Return -1 if the key is not found
        return prev.next.val; // Return the value associated with the key
    }
    
    // Function to remove a key-value pair from the HashMap
    public void remove(int key) {
        int idx = hash(key); // Calculate index for the key
        if(storage[idx] == null) return; // If the index is empty, return
        Node prev = search(storage[idx], key);
        if(prev.next == null) return; // If the key is not found, return
        Node temp = prev.next;
        prev.next = prev.next.next; // Remove the node containing the key
        temp.next = null;
    }
}
