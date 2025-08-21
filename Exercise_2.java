//We are going to use Linear hashing to check for collisions using Linked List
//the LinkedList node array is instantiated with 10^4 length to reduce the size of the inner linked list
//to avoid traversing a lot
//TC: O(1) because there can only be 100 elements in the inner linked list
//SC: O(1)
public class MyHashMap {

    private final Node[] storage;
    private final int buckets;

    /**
     * Linked List definition
     */
    public static class Node {
        int key;
        int value;
        Node next;

        /**
         * Constructor for linked list
         * @param key   the key to store
         * @param value the value for the key
         */
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Initializing constructor to set up the buckets and the storage
     */
    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    /**
     *
     * @param key the key to store in the map
     * @return Calculates and returns the hash key for the node array using modulo
     */
    private int hash(int key) {
        return key % buckets;
    }

    /**
     * The key value pair to store in the map
     * @param key   the key to store in the map
     * @param value the value for the key
     */
    public void put(int key, int value) {
        final int hash = hash(key);
        if (this.storage[hash] == null) {
            this.storage[hash] = new Node(-1, -1);
            Node root = this.storage[hash];
            root.next = new Node(key, value);
        } else {
            final Node prev = helper(this.storage[hash], key);
            //either we get the key in the linked list or we don't have current key in the list
            if (prev.next == null) {
                prev.next = new Node(key, value);
            } else {
                prev.next.value = value;
            }
        }
    }

    private Node helper(Node head, int key) {
        Node prev = head;
        Node current = prev.next;

        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        return prev;
    }

    /**
     *
     * @param key  the key to search for
     * @return the value corresponding to the key, if not present return -1
     */
    public int get(int key) {
        final int hash = hash(key);
        if (this.storage[hash] == null) return -1;

        final Node prev = helper(this.storage[hash], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    /**
     * @param key  the key to remove
     */
    public void remove(int key) {
        int hash = hash(key);
        if (this.storage[hash] == null) return;

        final Node prev = helper(this.storage[hash], key);
        if (prev.next != null) {
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        final MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

    }
}