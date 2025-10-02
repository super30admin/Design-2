package hashmap;

// Implementing hashmap using linear chaining - Primary data type is: LinkedList
// Time Complexity : O(1) for put, get and remove operations.
// Space Complexity: O(n) where n is the number of unique keys added to the Hash
public class MyHashMap {

    Node[] matrix;
    int arraySize;

    class Node {
        int key;
        int value;
        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // method to initialize the hashmap
    public MyHashMap() {
        arraySize = 10000;
        this.matrix = new Node[arraySize];
    }

    // method to find the hash value
    public int findHash(int key) {
        return key % arraySize;
    }

    // method to find the previous node of the given key
    public Node findPrevNode(int key, Node head) {
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null && currNode.key != key) {
            prevNode = prevNode.next;
            currNode = currNode.next;
        }

        return prevNode;
    }

    // method to add key value pair to the hashmap
    public void put(int key, int value) {
        int idx = findHash (key);

        if (matrix[idx] == null) {
            matrix[idx] = new Node(-1, -1); // add a dummy node
            Node actualNode = new Node(key, value);
            matrix[idx].next = actualNode;  // then add the actual key vale pair
            return;
        }

        Node prevNode = findPrevNode (key, matrix[idx]);
        if (prevNode.next == null) { // node is not found
            prevNode.next = new Node(key, value);
        } else {
            prevNode.next.value = value; // replace the new value for the existing key
        }
    }

    // method to get the value for the given key
    public int get(int key) {
        int idx = findHash (key);
        if (matrix[idx] == null) {
            return -1;
        }

        Node prevNode = findPrevNode (key, matrix[idx]);
        if (prevNode.next == null) {
            return -1;
        }

        return prevNode.next.value;

    }

    // method to remove the key value pair from the hashmap
    public void remove(int key) {
        int idx = findHash (key);
        if (matrix[idx] == null) {
            return;
        }

        Node prevNode = findPrevNode (key, matrix[idx]);
        if (prevNode.next == null) {
            return;
        }

        Node tmp = prevNode.next;
        prevNode.next = prevNode.next.next;
        tmp.next = null;
    }
}
