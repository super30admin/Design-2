/**
 * Primary DS: Array of size 10k, Secondary DS: List of size 100
 * hash function: %, Nodes of list contain key and value
 * Implement search function
 */
class MyHashMap {

    // Primary DS will be array.
    // Secondary DS actually storing key value pair will be a LL node
    // Let's create a node first and then array pointing to the nodes
    static class Node {
        int key;
        int value;
        Node next;

        // Constructor for Node class
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null; // Always default next pointer to null
        }
    }

    Node[] primaryArray;

    public MyHashMap() {
        // Initialize primary array.
        // Given the range of [0, 1M], we initialize array to size of 10k
        // And keep list to size of 100 for faster traversal
        primaryArray = new Node[10000];

        // Let's not initialize the list because, it can be created as and when needed.

    }

    // Let's create our hash function
    private int hash(int key) {
        return key % 10000; // Using 10k because array size is 10k
    }

    // Let's write a search function to avoid repeated code
    // This function returns a node previous to the target node
    private Node search(int key) {
        int primaryIndex = hash(key);
        Node previous = primaryArray[primaryIndex]; // Pointing to dummy node
        if (previous == null) {
            return previous; // List has not been initiated
        }
        Node current = previous.next; // Pointing to head node
        while (current != null) {
            if (current.key == key) {
                // Key found. Return previous.
                return previous;
            }
            previous = current;
            current = current.next;
        }
        return null; // If key not found, we return null
    }

    public void put(int key, int value) {
        // If list is not created, create it with a dummy node
        int primaryIndex = hash(key);
        if (primaryArray[primaryIndex] == null) {
            Node dummyNode = new Node(-1, -1);
            primaryArray[primaryIndex] = dummyNode;
            dummyNode.next = new Node(key, value);
        }

        Node previous = search(key);
        if (previous == null) {
            // Create new node at the end of list
            Node temp = primaryArray[primaryIndex];
            while (temp.next != null) {
                temp = temp.next;
            }
            // Now temp is last node of the list
            temp.next = new Node(key, value);
        } else {
            previous.next.value = value;
            return;
        }
    }

    public int get(int key) {
        int primaryIndex = hash(key);
        if (primaryArray[primaryIndex] == null) {
            return -1; // Since no list is found at the index mean element not present
        }
        Node previous = search(key);
        if (previous == null) {
            return -1; // Null previous implies node was not found in search
        } else {
            return previous.next.value;
        }
    }

    public void remove(int key) {
        int primaryIndex = hash(key);
        if (primaryArray[primaryIndex] == null) {
            return; // Nothing to remove
        }

        Node previous = search(key);
        if (previous == null) {
            return; // Null previous implies node was not found in search. Nothing to remove
        } else {
            Node current = previous.next;
            previous.next = current.next;
            current.next = null;
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