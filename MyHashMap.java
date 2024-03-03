class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] storage; // Array to store buckets

    public MyHashMap() {
        this.storage = new Node[10000]; // O(1) space
    }

    private int hash(int key) {
        return key % 10000; // O(1) time
    }

    // Time complexity: O(n) where n is the number of elements in the list
    // Space complexity: O(1)
    private Node search(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) { // Traverse the list until key is found or end of list is reached
            prev = curr;
            curr = curr.next;
        }
        return prev; // Return the node before the node with the key (or null if not found)
    }

    // Time complexity: O(n) where n is the number of elements in the list
    // Space complexity: O(1)
    public void put(int key, int value) {
        int idx = hash(key); // Hash the key to find index in storage array
        if (storage[idx] == null) {
            storage[idx] = new Node(-1, -1); // Initialize dummy node if bucket is empty
        }
        Node prev = search(storage[idx], key); // Find the node before the key
        if (prev.next == null) {
            prev.next = new Node(key, value); // Add new node if key not found in list
        } else {
            prev.next.value = value; // Update value if key found
        }
    }

    // Time complexity: O(n) where n is the number of elements in the list
    // Space complexity: O(1)
    public int get(int key) {
        int idx = hash(key); // Hash the key to find index in storage array
        if (storage[idx] == null) {
            return -1; // Key not found
        }
        Node prev = search(storage[idx], key); // Find the node before the key
        if (prev.next == null) return -1; // Key not found
        return prev.next.value; // Return value of the key
    }

    // Time complexity: O(n) where n is the number of elements in the list
    // Space complexity: O(1)
    public void remove(int key) {
        int idx = hash(key); // Hash the key to find index in storage array
        if (storage[idx] == null) return; // Key not found
        Node prev = search(storage[idx], key); // Find the node before the key
        if (prev.next == null) return; // Key not found
        Node temp = prev.next;
        prev.next = prev.next.next; // Remove the node
        temp.next = null; // Disconnect removed node from the list
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        // Inserting key-value pairs
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        hashMap.put(3, 300);

        // Retrieving values
        System.out.println("Value for key 1: " + hashMap.get(1)); // Output: 100
        System.out.println("Value for key 2: " + hashMap.get(2)); // Output: 200
        System.out.println("Value for key 3: " + hashMap.get(3)); // Output: 300

        // Removing a key
        hashMap.remove(2);

        // Trying to retrieve the removed key
        System.out.println("Value for key 2 after removal: " + hashMap.get(2)); // Output: -1 (since it's removed)
    }
}
