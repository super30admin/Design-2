// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        // Initialize a node
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    private int buckets;
    private Node[] storage; 

    // Initialize hash map
    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    // Function to calculate hash index
    private int hash(int key) {
        return key % buckets;
    }

    // Function to find the previous node of the node with given key
    private Node getPreviousElement(Node node, int key) {
        Node prev = null;
        Node curr = node;
        // Traverse the list till key is found or end of list is reached
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    // Function to insert an element with given key and value
    public void put(int key, int value) {
        int bucket = hash(key); 
        Node node = storage[bucket];
        // If there are no elements at the index add dummy node first and then create new node
        if(node == null) {
            node = new Node(-1,-1);
            storage[bucket] = node;
            storage[bucket].next = new Node(key, value);
            return;
        }

        // There are existing elements, add new node to end of list
        Node prev = getPreviousElement(node, key);
        if(prev.next == null) 
            prev.next = new Node(key, value);
        else
            prev.next.val = value;
    }
    
    // Function to get the value of a given key
    // Returns -1 if hash index is empty or element does not exist
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) 
            return -1;

        Node prev = getPreviousElement(storage[bucket], key);
        if(prev.next == null)
            return -1;
        return prev.next.val;
    }
    
    // Function to remove an element with the given key
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) 
            return;

        Node prev = getPreviousElement(storage[bucket], key);
        if(prev.next == null)
            return;
        Node deletedNode = prev.next;
        prev.next = deletedNode.next;
        deletedNode.next = null;
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}
